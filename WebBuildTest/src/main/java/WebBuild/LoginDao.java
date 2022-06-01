package WebBuild;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class LoginDao {

	private Connection con = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;


	public ResultSet selectUser(String id, String pass)
		throws SQLException {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/table",
							"root",
							"123456");

			ps = con.prepareStatement("select name, age from table.user where id = ? and pass = ?");

			ps.setString(1, id);
			ps.setString(2, pass);

			rs = ps.executeQuery();

		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
		return rs;
	}

	public void close() {
		try {
			if(con != null) {
				con.close();
			}if(ps != null) {
				con.close();
			}if(rs != null) {
				con.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
}}
