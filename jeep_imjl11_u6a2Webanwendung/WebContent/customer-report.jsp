<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="bericht" class="statistic.Report" scope="application" />
<title>Insert title here</title>
</head>
<body>
	<h2>Age distribution</h2>
	<table>
		<thead>
			<tr>
				<td>Age</td>
				<td>Count</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="age" items="${ bericht.getAgeDistribution() }">
				<tr>
					<td><c:out value="${ age.key }" /></td>
					<td><c:out value="${ age.value }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Country distribution</h2>
	<table>
		<thead>
			<tr>
				<td>Country</td>
				<td>Count</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="country" items="${ bericht.getCountryDistribution() }">
				<tr>
					<td><c:out value="${ country.key }" /></td>
					<td><c:out value="${ country.value }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>