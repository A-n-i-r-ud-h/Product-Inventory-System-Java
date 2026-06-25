<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add a new Product to Inventory</h2>
<form action='saveProd.jsp' method='post'>
 <div>Name:<input type='text' name='prodName'></div>
 <div>Quantity:<input type='text' name='prodQty'></div>
<div>Price:<input type='text' name='price'></div>
<div><button type='submit'>Save Product</button></div>
</form>
</body>
</html>