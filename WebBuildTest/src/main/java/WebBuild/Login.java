package WebBuild;

public class Login {
//hàm getUserData
	public LoginUserBean getUserData(String id, String pass) {

	LoginUserBean bean = new LoginUserBean();

	if("wed1".equals(id) && "123".equals(pass)) {

		bean.setId(id);
		bean.setName("hieu");
		bean.setAge(17);
	}else if("dangnhap 2".equals(id) && "password".equals(pass)) {
		bean.setId(id);
		bean.setName("hieu2");
		bean.setAge(16);
	}else {
		bean = null;
	}
	return bean;
}
}