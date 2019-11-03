<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
					<c:url var="showInvoicesLink" value="/showcustomers/showinvoices">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<c:url var="addInvoiceLink" value="/showcustomers/addinvoice">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.NIP} </td>
						<td> ${tempCustomer.company} </td>
						<td> <a href="${showInvoicesLink}">Show Invoices</a>  <a href="${addInvoiceLink}">Add Invoice</a> </td>
					</tr>
				
				</c:forEach>
						
			</table>
</div>
	<p>
		<a href="/InvoiceMaker/">Back to Menu</a>
	</p>
</body>
</html>