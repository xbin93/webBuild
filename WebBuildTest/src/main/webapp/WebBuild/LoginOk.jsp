<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user_db" scope="session" class="WebBuild.LoginUserBean" />

<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<h1>ログインユーザ情報</h1>
		<p>ID:<jsp:getProperty property="id" name="user_db"/></p>
		<p>名前:<jsp:getProperty property="name" name="user_db"/></p>
		<p>年齢:<jsp:getProperty property="age" name="user_db"/></p>
		<form>
			<input  type="button" onclick="location.href='./WebBuild/Login.jsp'" value="戻る">
		</form>
	</body>
</html>