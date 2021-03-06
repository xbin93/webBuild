package WebBuild;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB extends Login {

	@Override
	public LoginUserBean getUserData(String id, String pass) {

		LoginUserBean bean = null;
		LoginDao dao = null;
		ResultSet rs = null;

	try {
		dao = new LoginDao();

		rs = dao.selectUser(id, pass);

		while(rs.next()) {

			bean = new LoginUserBean();

			bean.setId(id);

			bean.setName(rs.getString("name"));

			bean.setAge(rs.getInt("age"));
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {

		dao.close();
	}

	return bean;

	}

}
