<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff | Teams</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<h1>Staff | Teams</h1>
	</header>
	<table>
		<tr>
			<th>NAME</th>
			<th>LOCATION</th>
			<th></th>
		</tr>
		<c:forEach items="${requestScope.allTeams}" var="t">
			<tr>
				<td>${t.name}</td>
				<td>${t.location}</td>
				<td><form action="deleteTeamServlet" method="post">
						<button type="submit" name="idToDelete" value="${t.teamId}">DEL</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="new-team.jsp">
		<button type="submit">ADD NEW TEAM</button>
	</form><br>
	<form action="viewEmployeeServlet">
		<button type="submit">GO TO EMPLOYEE LIST</button>
	</form><br>
	<form action="new-employee.jsp">
		<button type="submit">ADD NEW EMPLOYEE</button>
	</form>
	<footer>
		<h3 id="errorMessage">${errMsg}</h3>
	</footer>
</body>
</html>