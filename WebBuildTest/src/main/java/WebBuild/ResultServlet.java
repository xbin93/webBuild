package WebBuild;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	
	public ResultServlet() {
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String id =((LoginUserBean)request.getSession().getAttribute("user_db")).getId();
		String itemId = request.getParameter("item_id");
		String quanlity = request.getParameter("item_quanlity");
		ShoppingDao dao = new ShoppingDao();
		
		try {
			
			dao.updateItem(itemId, Integer.parseInt(quanlity));
			dao.updateHistory(id, itemId, Integer.parseInt(quanlity));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			dao.close();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("./WebBuild/result.jsp");
		
		rd.forward(request, response);
	}
}
