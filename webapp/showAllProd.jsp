<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <jsp:useBean id="prodDao" class="com.inventory.dal.ProdutDao" ></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table">
		<thead>
			<tr>
				<th>prodId</th>
				<th>prodName</th>
				<th>prodQty</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="prod" items="${prodDao.getAllProducts()}">
				<tr>
					<td>${prod.getProdId() }</td>
					<td>${prod.getProdName() }</td>
					<td>${prod.getProdQty() }</td>
					<td>${prod.getPrice() }</td>
					<td><input type='checkbox' value='${prod.getProdId()}'>Add To Inventory</td>
				</tr>
			</c:forEach>

		</tbody>


	</table>

</body>
</html>