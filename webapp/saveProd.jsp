<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.inventory.model.Product" %>
    
    <jsp:useBean id="prodDao"  class="com.inventory.dal.ProdutDao"></jsp:useBean>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String prodName = request.getParameter("prodName");
int prodQty = Integer.parseInt(request.getParameter("prodQty"));

double price = Double.parseDouble(request.getParameter("price"));
Product prodObj = new Product(prodName, prodQty, price);
int i = prodDao.addProduct(prodObj
		);

if(i>0){
	out.println("Saved product");
	
}

%>
</body>
</html>