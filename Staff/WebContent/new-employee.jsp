<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Employee</title>
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
		<input type="submit" name="action" value="add employee">
	</form>
	<footer><h3>${errMsg}</h3></footer>
</body>
</html>