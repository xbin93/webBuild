<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user_db" scope="session" class="WebBuild.LoginUserBean"/>

	<div align="right">
		ようこそ「<jsp:getProperty property="name" name="user_db"/>」さん！
		<a href="./LoginServlet?submit=history">購入履歴</a>
		<a href="./LoginServlet?submit=logout">ログアウト</a>
	</div>

</body>
</html>