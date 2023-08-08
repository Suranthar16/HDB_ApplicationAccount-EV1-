<%@ page import="java.util.ArrayList"%>
<%@ page import="HDBDTO.HDBRentalDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HDB_Update</title>
</head>
<script type="text/javascript">
 <%String message = request.getParameter("message");
if (message != null) {%>
	  alert("<%=message%>");
<%}%>
	
</script>
<body>
	<form id="id_scarch" name="id_scarch">
		<div>
			<h1>Update Rental Account</h1>

			<p>Enter Your Applicant ID :</p>
			<input type="text" id="id" name="id" value="" required placeholder="000"><br>
			<input type="button" id="scarch" name="scach" value="Scarch" onclick="scarchfun()">
		</div>
	</form>


	<div id="info" hidden="true">
		<form id="update_form" name="update_form">
			<%
			ArrayList<HDBRentalDTO> list = (ArrayList<HDBRentalDTO>) session.getAttribute("Specificlist");
			%>

			<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					HDBRentalDTO dto = list.get(i);
			%>

			<h4>Your Can Only Edit Applicant Preferred Zone</h4>

			<p>Applicant ID :</p>
			<input type="text" id="userid" name="userid" value="<%=dto.getID()%>"
				readonly>

			<p>
				Applicant Name :<%=dto.getName()%></p>


			<p>
				Applicant NRIC :<%=dto.getNRIC()%></p>


			<p>
				Applicant D.O.B :<%=dto.getDOB()%></p>


			<p>
				Applicant Choice :<%=dto.getChoice()%>Rooms
			</p>

			<%
			}
			}
			%>
			<p>Applicant Preferred Zone :</p>
			<select id="zone" name="zone" required>
				<option>--Select--</option>
				<option value="01">Tampines</option>
				<option value="02">Outram</option>
				<option value="03">Yishum</option>
				<option value="04">Jurong</option>
			</select><br> <input type="button" id="update" name="update"
				value="Update" onclick="updatefun()">
		</form>
	</div>

</body>
<script type="text/javascript">
	
<%String Show = request.getParameter("Show");
if (Show != null) {%>
	document.getElementById("info").hidden = false;
	console.log(document.getElementById("info").hidden);
<%}%>
	
</script>
<script type="text/javascript">
	function scarchfun() {
		var id = document.getElementById("id").value;

		if (id === "") {
			alert("Plese Enter Your ID!");
			return false;
		} else {
			document.getElementById("id_scarch").action = "HDBUpdateServlet"
			document.getElementById("id_scarch").method = "post"
			document.getElementById("id_scarch").submit();
		}
	}
</script>
<script type="text/javascript">
	function updatefun() {
		var Zone = document.getElementById("zone").value
		var userid = document.getElementById("userid").value

		
		if (userid === "") {
			alert("Please Check id!");
			return false;
		}
		if (Zone === "") {
			alert("Please Choose Applicant Zone!");
			return false;
		}

		else {
			document.getElementById("update_form").action = "HDBUpdateServlet"
			document.getElementById("update_form").method = "post"
			document.getElementById("update_form").submit();
		}
	}
</script>
</html>