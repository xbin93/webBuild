package WebBuild;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BuyItemServlet")
public class BuyItemServlet extends HttpServlet{

	public static final long versionUID = 1L;
	
	public BuyItemServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		Enumeration<String> names = request.getParameterNames();
		
		String name ="";
		String itemId ="";
		String quanlity ="";
		
		while(names.hasMoreElements()) {
			
			name = names.nextElement();
			
			if("購入".equals(request.getParameter(name))){
				
				itemId = name;
			}
		}
		
		quanlity = request.getParameter(itemId + "list");
		
		
		Shopping shopping = new Shopping();
		ItemBean bean = shopping.getItem(itemId);
		
		request.setAttribute("item", bean);
		request.setAttribute("quanlity", quanlity);
		
		RequestDispatcher rd = request.getRequestDispatcher("./WebBuild/confirm.jsp");
		
		rd.forward(request, response);
	}
}
