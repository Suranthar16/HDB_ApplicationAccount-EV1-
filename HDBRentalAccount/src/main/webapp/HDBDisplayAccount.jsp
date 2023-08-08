<%@ page import="java.util.ArrayList"%>
<%@ page import="HDBDTO.HDBRentalDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HDB_Display</title>
</head>
<body>

	<%
	ArrayList<HDBRentalDTO> list = (ArrayList<HDBRentalDTO>) session.getAttribute("Applicantlist");
	%>



	<h1>Display Overall Rental Account</h1>


	<table border="1">
		<tr>
			<th>Applicant ID:</th>
			<th>Applicant Name:</th>
			<th>Applicant NRIC:</th>
			<th>Applicant DOB:</th>
			<th>Applicant FlatChoice:</th>
			<th>Applicant Zone:</th>

			<th>Applicant Zone Tagged:</th>

		</tr>

		<%
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				HDBRentalDTO dto = list.get(i);
		%>


		<%
		String zone = dto.getZone();
		String value = "";
		String Tzone = "";
		if (zone != null) {

			if (Integer.parseInt(zone) == 01) {
				value = "Tampines";
				Tzone = "East";
			}
			if (Integer.parseInt(zone) == 02) {
				value = "Outram";
				Tzone = "South";
			}
			if (Integer.parseInt(zone) == 03) {
				value = "Yishun";
				Tzone = "North";
			}
			if (Integer.parseInt(zone) == 04) {
				value = "Jurong";
				Tzone = "West";
			}
		}
		%>


		<tr>
			<td><%=dto.getID()%></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getNRIC()%></td>
			<td><%=dto.getDOB()%></td>
			<td><%=dto.getChoice()%>Rooms</td>
			<td><%=value%></td>
			<td><%=Tzone%></td>
		</tr>

		<%
		}
		}
		%>
	</table>

</body>
</html>