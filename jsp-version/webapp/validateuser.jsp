<%@page import ="com.inventory.model.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="adminDao" class="com.inventory.dal.AdminDao"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String email =request.getParameter("email");
String password = request.getParameter("password");
try{
Admin admin=   adminDao.login(email, password);

if(admin!=null)
{
	session.setAttribute("adminObj", admin);
	out.print("Valid :"+admin);
   RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
   rd.forward(request, response);
}
else
{
	response.sendRedirect("login.jsp");
}
}catch(Exception e){
	e.printStackTrace();
}
%>

</body>
</html>