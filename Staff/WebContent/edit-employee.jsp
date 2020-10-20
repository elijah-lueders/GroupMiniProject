<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<h1>Edit Employee</h1>
	</header>
	<form action="updateEmployeeServlet" method="post" autocomplete="off">
		<input type="hidden" name="id" value="${empToEdit.id}">
		<label for="fname">First name</label><br> 
		<input type="text" id="fname" name="fname" value="${empToEdit.firstName}"><br><br> 
		<label for="lname">Last name</label><br> 
		<input type="text" id="lname" name="lname" value="${empToEdit.lastName}"><br><br>
		<label for="title">Title</label><br>
		<input type="text" id="title" name="title" value="${empToEdit.title}"><br><br>
		<label for="startdate">Start Date</label><br>
		<input type="date" id="startdate" name="startdate" value="${empToEdit.startDate}"><br><br>
		<label for="team">Change Team To</label><br>
		<select id="team" name="team">
			<option value="">No Change</option>
			<c:forEach items="${requestScope.allTeams}" var="team">
				<option value="${team.teamId}">${team.teamId}|${team.name}</option>
			</c:forEach>
		</select><br><br>
		<input type="submit" name="action" value="update employee">
	</form>
	<footer><h3>${errMsg}</h3></footer>
</body>
</html>