<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Add Customers</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Invoices of customer ${customer.firstName} ${customer.lastName}</h2>
		</div>
	</div>
		<table>
				<tr>
					<th>Date</th>
					<th>Invoice Id</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempInvoice" items="${invoices}">
				<c:url var="showInvoice" value="/showcustomers/showinvoices/showinvoice">
					<c:param name="customerId" value="${customer.id}"></c:param>
					<c:param name="invoiceId" value="${tempInvoice.id}"></c:param>
				</c:url>
					<tr>
						<td> ${tempInvoice.date} </td>
						<td> ${tempInvoice.id} </td>
						<td> <a href="${showInvoice}">Show Invoice</a> </td>
					</tr>
				
				</c:forEach>
		</table>
		<p>
			<a href="/InvoiceMaker/">Back to Menu</a>
		</p>



</body>

</html>
