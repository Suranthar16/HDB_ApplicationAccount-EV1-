<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HDB_Create
</title>
</head>
<script type="text/javascript">
 <% String message=request.getParameter("message");
 if(message!=null)
  {%>
	  alert("<%=message%>");
  <% }%>

</script>
<body>
<form id="create_form" name="create_form">
	<div>
		<h1>Create Rental Account</h1>

		<p>Applicant Name :</p>
		<input type="text" id="name" name="name" value="" required placeholder="ABC">

		<p>Applicant NRIC :</p>
		<input type="text" id="nric" name="nric" value="" required placeholder="ABC">

		<p>Applicant D.O.B :</p>
		<input type="date" id="dob" name="dob" value="" required>

		<p>Applicant Choice :</p>
		<select id="choice" name="choice" required>
			<option>--Select--</option>
			<option value="02">02 Rooms</option>
			<option value="05">05 Rooms</option>
		</select>

		<p>Applicant Preferred Zone :</p>
		<select id="zone" name="zone" required>
			<option>--Select--</option>
			<option value="01">Tampines</option>
			<option value="02">Outram</option>
			<option value="03">Yishum</option>
			<option value="04">Jurong</option>
		</select><br> <br> 
		
		<input type="button" id="save" name="save" value="Submit" onclick="savefun()"> 
		
		<input type="reset" id="clear" name="clear" value="Clear">

	</div>
	</form>
</body>
<script type="text/javascript">
function savefun() {
	var Name=document.getElementById("name").value
	var NRIC=document.getElementById("nric").value
	var DOB=document.getElementById("dob").value
	var Choice=document.getElementById("choice").value
	var Zone=document.getElementById("zone").value
	
	
	if(Name===""){
		alert("Please Enter Applicant Name!");
		return false;
	}
	if(NRIC===""){
		alert("Please Enter Applicant NRIC!");
		return false;
	}
	if(DOB===""){
		alert("Please Enter Applicant DOB!");
		return false;
	}
	if(Choice===""){
		alert("Please Choose Applicant Choice!");
		return false;
	}
	if(Zone===""){
		alert("Please Choose Applicant Zone!");
		return false;
	}
	else{
		document.getElementById("create_form").action="HDBCreateServlet"
		document.getElementById("create_form").method="post"
		document.getElementById("create_form").submit();
	}
}


</script>
</html>