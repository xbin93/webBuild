package WebBuild;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingDao {
		
	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	public ResultSet selectItem() throws SQLException{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table",
					"root", "123456");
			ps = con.prepareStatement("select item.item_id, item.item_name, item.price, stok.quanlity from item inner join stok on item.item_id = stok.item_id");
			
			rs = ps.executeQuery();
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		return rs;
	}
	
	
	public ResultSet selectItem(String itemId) throws SQLException{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table",
					"root", "123456");
			
			ps = con.prepareStatement("select item.item_name, item.price, stok.quanlity from item inner join stok on item.item_id = stok.item_id where item.item_id = ?");
			
			ps.setString(1, itemId);
			
			rs = ps.executeQuery();
		}catch(ClassNotFoundException ce) {
			
			ce.printStackTrace();
		}
		
		return rs;
	}
	
	
	public ResultSet selectHistory(String id) throws SQLException{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table",
					"root", "123456");
			
			ps = con.prepareStatement("select history.item_id, item.item_name, history.quanlity from history inner join item on history.id =? and history.item_id = item.item_id");
			ps.setString(1, id);
			
			rs =ps.executeQuery();
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
		return rs;
	}
	
	
	public void updateItem(String itemId, int quanlity) throws SQLException{
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table", 
											  "root",
											  "123456");
			
			ps = con.prepareStatement("update stok set quanlity = quanlity - ? where item_id= ?");
			ps.setInt(1, quanlity);
			ps.setString(2, itemId);
			
			ps.executeUpdate();
		}catch(ClassNotFoundException ce) {
			
			ce.printStackTrace();
		}
	}
	
	
	public void updateHistory(String id, String itemId, int quanlity) 
		throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table",
					"root" ,"123456");
			ps = con.prepareStatement("insert into history(id, item_id, quanlity) values(?,?,?)");
			ps.setString(1, id);
			ps.setString(2, itemId);
			ps.setInt(3, quanlity);
			
			ps.executeUpdate();
		
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		
	}


	
	
	public void close() {
		try {
			if(con != null) {
				con.close();				
			}if(ps != null) {
				ps.close();
			}if(rs != null) {
				rs.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
}
