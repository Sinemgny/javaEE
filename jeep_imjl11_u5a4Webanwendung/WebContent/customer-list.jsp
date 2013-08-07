<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="dao" class="code.CustomerDAOClient" scope="application" />
<title>Insert title here</title>

<style type="text/css">
tr {
    background-color: lightgrey;
   }
   
   tr.values {
   	background-color: white;
   }
  </style>
  
</head>
<body>
<h1>Customer list</h1>

<a href="Controller?action=CustomerFormAction">Add Customer</a>
<br>
<a href="Controller/clist.pdf?action=CustomerPDFAction">Download customer list as PDF</a>

<table>
	<tr>
		<td>
			id
		</td>
		<td>
			name
		</td>
		<td>
			first name
		</td>
		<td>
			email
		</td>
		<td>
			age
		</td>
		<td>
			country
		</td>
		<td>
			
		</td>
	</tr>
	<c:forEach var="customer" items="${ dao.dao.findAll() }">
		<tr class="values">
					<td> ${ customer.id }</td>
					<td> ${ customer.name }</td>
					<td> ${ customer.firstName }</td>
					<td> ${ customer.email }</td>
					<td> ${ customer.age }</td>
					<td> ${ customer.country }</td>
					<td>	<a href="Controller?action=CustomerEditAction&id=${customer.id}">edit</a>|
							<a href="Controller?action=CustomerDeleteAction&id=${customer.id}">delete</a>
					</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>