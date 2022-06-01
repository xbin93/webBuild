<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="WebBuild.HistoryBean" %>
<jsp:useBean id="user_db" scope="session" class="WebBuild.LoginUserBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
<link href="./WebBuild/shopping.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1><jsp:getProperty property ="name" name="user_db"/>さんの購入履歴</h1>
	
	
	<% ArrayList<HistoryBean> historyList = (ArrayList<HistoryBean>)request.getAttribute("history"); %>
	<table class="table_list">
		<tbody>
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>購入数</th>
				</tr>
			<% for(HistoryBean bean : historyList) {%>
				<tr>
					<td><%= bean.getItemId() %></td>
					
					<td><%= bean.getItemName() %></td>
					
					<td class="int"><%= bean.getQuanlity() %></td>
				</tr>
			<%} %>	
		</tbody>
	</table>
	<form action="./ShoppingServlet" method="post">
		<input class="common_button" type="submit" value="一覧に戻る">
	</form>
</body>
</html>