<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Show Customers</title>
</head>
<body>
<h2>Show customers</h2>


<div>
		<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>NIP</th>
					<th>Company</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.NIP} </td>
						<td> ${tempCustomer.company} </td>
						<td> Empty </td>
					</tr>
				
				</c:forEach>
						
			</table>
</div>
	<p>
		<a href="/InvoiceMaker/">Back to Menu</a>
	</p>
</body>
</html>