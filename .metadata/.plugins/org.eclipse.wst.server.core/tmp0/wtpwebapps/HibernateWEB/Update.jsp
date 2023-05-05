<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
	<%
	User u = null;
	if (request.getAttribute("data") != null) {
		u = (User) request.getAttribute("data");
	} 
	%>
	
	<form action="UserController" method="post">
		<table>
			<tr>
				<td><input type="hidden" name="ID" value="<%=u.getID()%>"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="Name" value="<%=u.getName()%>"></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><input type="text" name="Contact" value="<%=u.getContact()%>"></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><input type="text" name="Address" value="<%=u.getAddress()%>"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="Email" value="<%=u.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="Password" value="<%=u.getPassword()%>"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Update"></td>
			</tr>
		</table>
	</form>

</body>
</html>