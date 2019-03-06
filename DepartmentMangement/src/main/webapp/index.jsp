<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<!-- linking css file -->
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="body">
		<div class="header">
			<h1>Employee Registration Screen</h1>
		</div>
		<div class="form1">
			<!-- employee registration form starts here -->
			<form id="registration" action="Addemployee" method="post"
				onsubmit="return validate()">
				<fieldset>
					<table>
						<tr>
							<p class="header2">ADD EMPLOYEES</p>
						</tr>

						<tr>
							<td align='center'>First Name:</td>
							<td><input type='text' name='fname' required="required"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align='center'>Last Name:</td>
							<td><input type='text' name='lname' required="required"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align='center'>Age:</td>
							<td><input type='number' name='age'
								placeholder="Enter age in years" min="10" max="100"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align='center'>Salary:</td>
							<td><input type='number' step="0.01" name='salary' min="1"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td align='center'>Department:</td>
							<td>&nbsp; <select name="Depart" required="required"><option
										value="">---Select---</option>
									<%
										try {
											Class.forName("com.mysql.jdbc.Driver").newInstance();
										} catch (ClassNotFoundException e) {
											e.printStackTrace();
										}
										String connectionURL = "jdbc:mysql://localhost:3306/employeedetails";
										Connection connection = DriverManager.getConnection(connectionURL, "root", "123");
										PreparedStatement psmnt = connection.prepareStatement("select * from department ");
										ResultSet results = psmnt.executeQuery();
										while (results.next()) {
											String name = results.getString(2);
											String id = results.getString(1);
									%><option value="<%=name%>">
										<%
											out.println(name);
										%>
									</option>
									<%
										}
										results.close();
										psmnt.close();
									%>
							</select><br></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>

						<tr>
							<td align='center'><input type='submit' name='REGISTER'
								value="REGISTER" onsubmit="validate()"></td><td> <input
								type='reset' name='RESET' value="RESET"></td>
						</tr>
						<tr>

						</tr>
					</table>
				</fieldset>
			</form>
			<!-- employee registration form ends here -->
		</div>
	</div>
	<!-- successful entry message -->
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
			out.write("<h1 style='color:red'>" + msg + "</h1>");
		}
	%>

	<div>
		<!-- employee details display as table starts here -->
		<table dir="ltr" class="table2">
			<caption>Employee List</caption>
			<colgroup width="50%" />
			<colgroup id="colgroup" class="colgroup" align="center"
				valign="middle" title="title" width="1*" span="2" />
			<thead>
				<tr>
					<th scope="col">Employee ID</th>
					<th scope="col">FirstName</th>
					<th scope="col">LastNmae</th>
					<th scope="col">Age</th>
					<th scope="col">Salary</th>
					<th scope="col">Department</th>
				</tr>
			</thead>

			<tbody>

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					Connection con = DriverManager.getConnection(connectionURL, "root", "123");
					PreparedStatement ps = con.prepareStatement(
							"select employee.eid, employee.fname, employee.lname, employee.age, employee.salary,department.department_name from employee, department where employee.department_id=department.department_id");
					ResultSet result = ps.executeQuery();
					while (result.next()) {
				%>
				<tr>
					<td><%=result.getInt("eid")%></td>
					<td><%=result.getString("fname")%></td>
					<td><%=result.getString("lname")%></td>
					<td><%=result.getInt("age")%></td>
					<td><%=result.getFloat("salary")%></td>
					<td><%=result.getString("department_name")%> <%
 	}
 %>
				</tr>
			</tbody>
		</table>
		<br/><br/><br/>
		<!-- employee details display as table ends here -->
	</div>
	
	<script type="text/javascript">
		// Form validation code will come here.
		function validate() {
			if (document.registration.fname.value == "") {
				alert("Please provide your name!");
				document.registration.fname.focus();
				return false;
			}
			if (document.registration.lname.value == "") {
				alert("Please provide your name!");
				document.registration.lname.focus();
				return false;
			}

			return (true);

		}
	</script>
	
</body>
</html>
