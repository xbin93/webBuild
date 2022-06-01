package WebBuild;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public ShoppingServlet() {
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		Shopping shopping = new Shopping();
		ArrayList<ItemBean> itemList = shopping.getItem();
		
		request.setAttribute("itemList", itemList);
		
		RequestDispatcher rd = request.getRequestDispatcher("./WebBuild/itemList.jsp");
		
		rd.forward(request, response);
	}
}
