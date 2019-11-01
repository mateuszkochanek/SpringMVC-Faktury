<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>

<head>
	<title>Add Products</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add Product</h2>
		</div>
	</div>
	
	<div id="container">
		<form:form action="saveproduct" modelAttribute="product" method="POST" >
		
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>name:</label></td>
						<td><form:input path="name"/></td>
					</tr>
					
					<tr>
						<td><label>price:</label></td>
						<td><form:input type="number" step="0.01" path="price"/></td>
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
