<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HDB_main</title>
</head>
<body>

	<div style="text-align: center;">
		<h1>HOUSING & DEVELOPEMENT BOARD</h1>
		<input type="button" id="Create" name="Create"
			value="Create Rental Account" onclick="Createfun()"><br>
		<input type="button" id="Update" name="Update"
			value="Update Rental Account" onclick="Updatefun()"><br>
		<input type="button" id="Delete" name="Delete"
			value="Delete Rental Account" onclick="Deletefun()"><br>
		<input type="button" id="Display" name="Display"
			value="Display Overall Rental Account" onclick="Displayfun()">
	</div>


</body>
<script type="text/javascript">
	function Createfun() {

		location.replace("HDBCreateAccount.jsp");
	}
	function Updatefun() {

		location.replace("HDBUpdateAccount.jsp");
	}
	function Deletefun() {

		location.replace("HDBDeleteAccount.jsp");
	}
	function Displayfun() {

		location.replace("HDBDisplayServlet");
	}
</script>
</html>