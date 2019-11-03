<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Add Invoice</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Create Invoice to Save</h2>
		</div>
	</div>

			<table>
				<tbody>
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
				</tr>
			<c:url var="addSubjectDetail" value="/showcustomers/saveinvoicesubject">
					<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
		<form:form action="${addSubjectDetail}" modelAttribute="subject" method="POST" >
				<tr>
					<th>
						<form:select path="productId">
							<form:option value="-1" label="--Please Select"/>
							<form:options items="${products}"  itemValue="id" itemLabel="name" type="number"/>
						</form:select>
					</th>
					<th><form:input path="count"  type="number"/></th>
					<th><input type="submit" value="save"/></th>
				</tr>
		</form:form>
			<tr>
					<th>Product</th>
					<th>Count</th>
					<th>Price</th>
			</tr>
		<c:forEach var="tempInvoiceSubject" items="${subjects}">
					<tr>
						<td> ${tempInvoiceSubject.product.name} </td>
						<td> ${tempInvoiceSubject.count} </td>
						<td> ${tempInvoiceSubject.finalPrice} </td>
					</tr>
		</c:forEach>
		<form:form action="/InvoiceMaker/showcustomers/saveinvoice" modelAttribute="invoice" method="POST" >
				<form:input path="customerId" type="hidden" value="${customer.id}"/>
				<input type="submit" value="Save Invoice"/>
		</form:form>
	</table>
</body>

</html>
