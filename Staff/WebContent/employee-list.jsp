<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff | Employees</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<h1>Staff | Employees</h1>
	</header>
	<table>
		<tr>
			<th>NAME</th>
			<th>TITLE</th>
			<th>TIME ONBOARD</th>
			<th>TEAM</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${requestScope.allEmployees}" var="e">
			<tr>
				<td>${e.firstName}&nbsp;${e.lastName}</td>
				<td>${e.title}</td>
				<td>${e.daysEmployed}</td>
				<td>${e.team.name}</td>
				<td><form action="editEmployeeServlet" method="post">
						<button type="submit" name="idToEdit" value="${e.id}">EDIT</button>
					</form></td>
				<td><form action="deleteEmployeeServlet" method="post">
						<button type="submit" name="idToDelete" value="${e.id}">DEL</button>
					</form></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<form action="newEmployeeServlet">
		<button type="submit">ADD NEW EMPLOYEE</button>
	</form><br>
	<form action="viewTeamServlet">
		<button type="submit">GO TO TEAM LIST</button>
	</form><br>
	<form action="new-team.jsp">
		<button type="submit">ADD NEW TEAM</button>
	</form>
	<footer>
		<h3 id="errorMessage">${errMsg}</h3>
	</footer>
</body>
</html>