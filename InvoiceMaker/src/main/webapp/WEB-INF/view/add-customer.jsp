<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Add Customers</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		<form:form action="savecustomer" modelAttribute="customer" method="POST" >
		
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					
					<tr>
						<td><label>NIP:</label></td>
						<td><form:input path="NIP"/></td>
					</tr>
					
					<tr>
						<td><label>Company:</label></td>
						<td><form:input path="company"/></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="save"/></td>
					</tr>
				</tbody>
			</table>
		
		</form:form>

				<div></div>
		<p>
			<a href="/InvoiceMaker/">Back to Menu</a>
		</p>
	</div>


</body>

</html>
