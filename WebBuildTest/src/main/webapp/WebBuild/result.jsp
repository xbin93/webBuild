<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Shop</title>
	<link href="./WebBuld/shopping.css" rel="stylesheet" type ="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h2 >購入結果</h2>
	<p>購入しました</p>
		<form action="./ShoppingServlet" method="post">
			<input class="common_button" type="submit" value="一覧に戻る">
		</form>	<p>
</body>
</html>