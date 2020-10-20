<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Team</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<header>
		<h1>New Team Form</h1>
	</header>
	<form action="newTeamServlet" method="post" autocomplete="off">
		<label for="name">Team Name</label><br> 
		<input type="text" id="name" name="name"><br><br> 
		<label for="location">Location</label><br>
		<input type="text" id="location" name="location"><br><br>
		<input type="submit" name="action" value="CREATE TEAM">
	</form>
	<br>
	<form action="viewTeamServlet">
		<button type="submit">GO TO TEAM LIST</button>
	</form>
	<footer><h3>${errMsg}</h3></footer>
</body>
</html>