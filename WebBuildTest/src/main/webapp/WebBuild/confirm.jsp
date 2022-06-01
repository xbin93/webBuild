<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="item" scope="request" class="WebBuild.ItemBean"/>


<!DOCTYPE html>
<html>
	<head>
		<title>Shop</title>
		<link href="./WebBuild/shopping.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<h1>購入確認</h1>
		<p>つぎの商品を購入しますか？</p>
		<form action="./ResultServlet" method="post">
			<table class="table_list">
				<tbody>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>在庫数</th>
						<th>購入数</th>
					</tr>
					<tr>
						<td><jsp:getProperty property="itemId" name="item"/></td>
						<td><jsp:getProperty property="itemName" name="item"/></td>
						<td class="int"><jsp:getProperty property="price" name="item"/></td>
						<td class="int"><jsp:getProperty property="quanlity" name="item"/></td>
						<td class="int"><%=request.getAttribute("quanlity")%></td>
						<td class="button">
							<input class="common_button" type="submit" value="購入">
								<input type="hidden" name="item_id" value="<%=item.getItemId()%>"/>
								<input type="hidden" name="item_quanlity" value="<%=request.getAttribute("quanlity")%>" />
							
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<form action="./ShoppingServlet" method="post">
			<input class="common_button" type="submit" value="一覧に戻る">
		</form>
	</body>
</html>