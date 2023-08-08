<%@ page import="java.util.ArrayList"%>
<%@ page import="HDBDTO.HDBRentalDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HDB_Delete</title>
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
			<h1>Delete Rental Account</h1>

			<p>Enter Your Applicant ID :</p>
			<input type="text" id="id" name="id" value="" required placeholder="000"><br> 
			<input type="button" id="scarch" name="scach" value="Scarch" onclick="scarchfun()">
		</div>
	</form>
	<div id="info" hidden="true">
		<form id="delete_form" name="delete_form">
			<%
			ArrayList<HDBRentalDTO> list = (ArrayList<HDBRentalDTO>) session.getAttribute("Specificlist");
			%>

			<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					HDBRentalDTO dto = list.get(i);
			%>

			<h4>Your Can Only View & Delete Applicant Account</h4>

			<p>Applicant ID :</p>
			<input type="text" id="userid" name="userid" value="<%=dto.getID()%>" readonly>

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
			String zone = dto.getZone();
			String value = "";

			if (zone != null) {

				if (Integer.parseInt(zone) == 01) {
					value = "Tampines";
				}
				if (Integer.parseInt(zone) == 02) {
					value = "Outram";
				}
				if (Integer.parseInt(zone) == 03) {
					value = "Yishun";
				}
				if (Integer.parseInt(zone) == 04) {
					value = "Jurong";
				}
			}
			%>

			<p>
				Applicant Preferred Zone :<%=value%></p>
			<%
			}
			}
			%>
			<input type="button" id="delete" name="delete" value="Delete"
				onclick="deletefun()">
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
			document.getElementById("id_scarch").action = "HDBDeleteServlet"
			document.getElementById("id_scarch").method = "post"
			document.getElementById("id_scarch").submit();
		}
	}
</script>
<script type="text/javascript">
	function deletefun() {
		var userid = document.getElementById("userid").value

		alert(userid)
		if (userid === "") {
			alert("Please Check id!");
			return false;
		}

		else {
			document.getElementById("delete_form").action = "HDBDeleteServlet"
			document.getElementById("delete_form").method = "post"
			document.getElementById("delete_form").submit();
		}
	}
</script>
</html>