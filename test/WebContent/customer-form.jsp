<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
	<jsp:directive.page
		contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"/>
	<jsp:output
		doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<title>Customer form</title>
		</head>
		<body>
			<h1>Customer form</h1>
			<form action="Controller?action=CustomerListAction" method="post">
				<input type="hidden" name="subaction" value="save" />
				<input type="hidden" name="id" value="${customer.id}" />
				<table>
				 	<tr>
				 		<td>Name</td>
				 		<td><input type="text" name="name" value="${customer.name}"/></td>
				 		<td>${errorMsgs.name}</td>
				 	</tr>
					<tr>
						<td>First Name</td>
						<td><input name="firstName" type="text" value="${customer.firstName}"/></td>
						<td>${errorMsgs.firstName}</td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input name="email" type="text" value="${customer.email}"/></td>
						<td>${errorMsgs.email}</td>
					</tr>
					<tr>
						<td>Birthday</td>
						<td><input name="birthday" type="text" value="${customer.birthday}"/></td>
						<td>${errorMsgs.birthday}</td>
					</tr>
					<tr>
						<td>Country</td>
						<td><input name="country" type="text" value="${customer.country}"/></td>
						<td>${errorMsgs.country}</td>
					</tr>
					<tr>
						<td><input type="submit" /></td>
						<td><input type="reset" /></td>
					</tr>
				</table>
			</form>
		</body>
	</html>
</jsp:root>