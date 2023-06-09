<%@page import="Dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>

	<%
	User u = null;
	if (session.getAttribute("data") != null) {
		u = (User) session.getAttribute("data");
	} else {
		response.sendRedirect("Login.jsp");
	}
	%>
	
	
	<h1 class="text-center mt-3 mb-3">All Data</h1>
	<table class="container table table-dark table-striped">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">NAME</th>
				<th scope="col">CONTACT</th>
				<th scope="col">ADDRESS</th>
				<th scope="col">EMAIL</th>
				<th scope="col">EDIT</th>
				<th scope="col">DELETE</th>
			</tr>
		</thead>
		<tbody>
		
		<% List<User> list = new UserDao().getAllUser(); %>
		<% for(User u1 : list){ %>
		
			<tr>
				<th scope="row"><%=u1.getID()%></th>
				<td><%=u1.getName() %></td>
				<td><%=u1.getContact() %></td>
				<td><%=u1.getAddress() %></td>
				<td><%=u1.getEmail() %></td>
				<td>
					<form action="UserController" method="post">
						<input type="hidden" name="ID" value="<%=u1.getID()%>">
						<input type="submit" name="action" value="Edit">
					</form>
				</td>
				<td>
					<form action="UserController" method="post">
						<input type="hidden" name="ID" value="<%=u1.getID()%>">
						<input type="submit" name="action" value="Delete">			
					</form>
				</td>
			</tr>
		
		<%} %>	
			
		</tbody>
	</table>

	<h1 class="text-center">
		<a href="Logout.jsp">Logout</a>
	</h1>
</body>
</html>