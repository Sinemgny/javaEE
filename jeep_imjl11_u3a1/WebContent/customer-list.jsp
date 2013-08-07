<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

<jsp:useBean id="list" class="source.CustomerList" scope="application"/>

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

<a href="Controller?action=customer-form">Add Customer</a>
<br>
<a href="Controller/clist.pdf?action=customer-list-pdf">Download customer list as PDF</a>

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
			
		</td>
	</tr>
	<c:forEach var="key" items="${ list.map }">
		<tr class="values">
					<td> ${ key.value.id }</td>
					<td> ${ key.value.name }</td>
					<td> ${ key.value.firstName }</td>
					<td> ${ key.value.email }</td>
					<td>	<a href="Controller?action=customer-edit&id=${key.value.id}">edit</a>|
							<a href="Controller?action=customer-delete&id=${key.value.id}">delete</a>
					</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>