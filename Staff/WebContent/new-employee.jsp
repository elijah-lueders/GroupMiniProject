<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Employee</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<h1>New Employee Form</h1>
	</header>
	<form action="newEmployeeServlet" method="post" autocomplete="off">
		<label for="fname">First name</label><br> 
		<input type="text" id="fname" name="fname"><br><br> 
		<label for="lname">Last name</label><br> 
		<input type="text" id="lname" name="lname"><br><br>
		<label for="title">Title</label><br>
		<input type="text" id="title" name="title"><br><br>
		<label for="startdate">Start Date</label><br>
		<input type="date" id="startdate" name="startdate"><br><br>
		<label for="team">Add to Team</label><br>
		<select id="team" name="team">
			<option value="">No Team</option>
			<c:forEach items="${requestScope.allTeams}" var="team">
				<option value="${team.teamId}">${team.teamId}|${team.name}</option>
			</c:forEach>
		</select><br><br>
		<input type="submit" name="action" value="CREATE EMPLOYEE">
	</form><br>
	<form action="viewEmployeeServlet">
		<button type="submit">GO TO EMPLOYEE LIST</button>
	</form>
	<footer><h3>${errMsg}</h3></footer>
</body>
</html>