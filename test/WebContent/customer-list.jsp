<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
<jsp:directive.page import="java.util.Map"/>
<jsp:directive.page import="java.util.HashMap"/>
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" />
	<jsp:output
		doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
		<head>
			<style type="text/css">
			th {
				background-color: #D3D3D3;
			}
			</style>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
			<title>Customer List</title>
		</head>
		<body>
			<h1>Customer List</h1>
			<p>
				<a href="Controller?action=CustomerFormAction">Add Customer</a>
				<br />
				<a href="Controller/clist.pdf?action=CustomerListPdfAction">Download customer list as PDF</a>
			</p>
			<p>
				<a href="Controller?action=StatisticSummaryAction">See Browser &amp; OS statistics</a>
				<br />
				<a href="Controller?action=ShowReportAction">Show report</a>
				<br />
				<a href="Controller?action=ShowSessionsAction">Show Sessions</a>
			</p>
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>First Name</th>
					<th>Email</th>
					<th>Birthday</th>
					<th>Country</th>
					<th></th>
				</tr>
				<c:forEach items="${cmap}" var="cum">
					<tr>
						<td>${cum.key}</td>
						<td>${cum.value.name}</td>
						<td>${cum.value.firstName}</td>
						<td>${cum.value.email}</td>
						<td>${cum.value.birthday}</td>
						<td>${cum.value.country}</td>
						<td><a href="Controller?action=CustomerFormAction&amp;id=${cum.key}">edit</a> | <a href="Controller?action=CustomerDeleteAction&amp;id=${cum.key}">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</body>
	</html>
</jsp:root>