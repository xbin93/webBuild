package WebBuild;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("submit"); //submit bên Login.jsp

		HttpSession session = request.getSession();
		RequestDispatcher rd;



	if("ログイン".equals(btn)) {

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		LoginDB login = new LoginDB();

		LoginUserBean bean = login.getUserData(id, pass);

		if(bean != null) {
			session.setAttribute("user_db", bean);

			session.setAttribute("login_db", "login");

			rd = request.getRequestDispatcher("./ShoppingServlet");

		}else {

			rd = request.getRequestDispatcher("./WebBuild/LoginNG.jsp");
		}
			rd.forward(request, response);
}else if("logout".equals(btn)) {
		session.removeAttribute("login_db");
		session.removeAttribute("user_db");
		response.sendRedirect("./WebBuild/Login.jsp");
}else if("history".equals(btn)) {
	
		Shopping shopping = new Shopping();
		
		String id =((LoginUserBean)session.getAttribute("user_db")).getId();
		
		ArrayList<HistoryBean> bean = shopping.getHistory(id);
		
		request.setAttribute("history", bean);
		rd = request.getRequestDispatcher("./WebBuild/History.jsp");
		rd.forward(request, response);
	}

}	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
	
	doPost(request, response);
	}
}
		
	

	
