<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="WebBuild.ItemBean" %>
<%@ page import="java.util.ArrayList" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebBuild</title>
<link href="./WebBuild/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1>商品一覧</h1>
	
	<% ArrayList<ItemBean> itemList = (ArrayList<ItemBean>)request.getAttribute("itemList"); %>
	<form action ="./BuyItemServlet">
		<table class ="table_list">
			<tbody>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫数</th>
					<th>数量</th>
				</tr>
				
				<% for(ItemBean bean : itemList){ %>
				<tr>
					<td><%= bean.getItemId() %></td>
					
					<td><%= bean.getItemName() %></td>
					
					<td class="int"><%= bean.getPrice() %></td>
					
					<td class="int"><%= bean.getQuanlity() %></td>
					
				<% if(bean.getQuanlity() != 0) {%>
				
				<td>
					<select class="list" name="<%= bean.getItemId() %>list">
						<% for(int i=0; i<= bean.getQuanlity(); i++) {%>
							<option value =<%= i %>><%=i %></option>
						<%} %> 
					</select>
				</td>
				<td class ="button">
					<input class ="common_button"	type="submit" value="購入" name="<%= bean.getItemId() %>">
				</td>	
				<% }else { %>
				<td></td>
				<td class="button">売り切れ</td>
				<%} %>
				</tr>
				<% } %>	
			</tbody>
			<input class="common_button" type="button" onclick="location.href='./WebBuild/Login.jsp'" value="戻る"/>
		</table>
	</form>
</body>
</html>