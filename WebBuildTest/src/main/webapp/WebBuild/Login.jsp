<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "user_db" scope ="session" class = "WebBuild.LoginUserBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>WebBuild</title>
	<link href="/WebBuildTest/WebBuild/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="bg"></div>
<section>
	<form action = "../LoginServlet" method = "post">
		
		<p>ユーザー名</p>
		<div class="form-field">
			<input type ="text" placeholder = "username" name = "id" value ="<%= user_db.getId() %>"/>
		</div>
		
		<p>パスワード</p>
		<div class="form-field">
			<input type ="password" placeholder ="password" name ="pass"/>
		</div>
		
		<input class ="btn" type ="submit" name ="submit" value ="ログイン"/>
		
		<%if("login".equals(session.getAttribute("login_db"))){%>
		<input class ="btn" type ="submit" name ="submit" value ="ログアウト"/>
		<% } %>
	</form>
<br>	
	<form>
	<div>
		<input class="btn" type="button" name="register" value="登録">
	</div>
	</form>
</section>

</body>
</html>