<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Customer form</title>

<jsp:useBean id="list" class="source.CustomerList" scope="application" />
<jsp:useBean id="customer" class="source.Customer" scope="request">
	<jsp:setProperty name="customer" property="*" />
</jsp:useBean>
</head>
<body>
	<h1>Customer form</h1>
	<table>
		<form action="Controller?action=customer-form" method="post">
			<input type="hidden" name="subaction" value="save" /> 
			<input type="hidden" name="id" value="${customer.id}" /> 
			<tr>
			<td>Name</td><td> <input type="text" name="name" value="${customer.name}" />${errorMsgs.name}</td>
			</tr>
			<tr>
			<td>First name</td><td> <input name="firstName" type="text" value="${customer.firstName}" /> ${errorMsgs['firstName']}</td>
			</tr>
			<tr>
 			<td>Email</td><td> <input name="email" type="text" value="${customer.email}" />${errorMsgs.email}</td>
			</tr>
			<tr>
			<td><input type="submit" /></td>
			</tr>	
		</form>
	</table>
</body>
</html>
</jsp:root>