<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Invoice:</title>
</head>
<body>
	<table>
			<tbody>
					<tr>
						<td><label>Date: ${invoice.date}</label></td>
					</tr>
					<tr>
						<td><label>First name: ${customer.firstName}</label></td>
					</tr>
					
					<tr>
						<td><label>Last name: ${customer.lastName}</label></td>
					</tr>
					
					<tr>
						<td><label>NIP: ${customer.NIP}</label></td>
					</tr>
					
					<tr>
						<td><label>Company: ${customer.company}</label></td>
					</tr>
			</tbody>
		</table>
		<table>
				<tr>
					<th>Product</th>
					<th>Count</th>
					<th>Price for one Item</th>
					<th>Price</th>
				</tr>
				<c:forEach var="tempInvoiceSubject" items="${invoice.invoiceSubjects}">
					<tr>
						<td> ${tempInvoiceSubject.product.name} </td>
						<td> ${tempInvoiceSubject.count} </td>
						<td> ${tempInvoiceSubject.product.price} </td>
						<td> ${tempInvoiceSubject.finalPrice} </td>
					</tr>
				</c:forEach>
				<tr>
					<th>Sum:</th>
					<th></th>
					<th></th>
					<th>${sumPrice}</th>
				</tr>
		</table>
		<p>
			<a href="/InvoiceMaker/">Back to Menu</a>
		</p>



</body>

</html>
