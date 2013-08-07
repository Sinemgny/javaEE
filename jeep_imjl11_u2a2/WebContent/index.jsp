<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task 2</title>

<jsp:useBean id="randomColor" class="color.RandomColor">
	<jsp:setProperty name="randomColor" property="count"/>
</jsp:useBean>
	
</head>
<body>
<table>
 <c:forEach items="${randomColor.colors}" var="color">
 	<tr >
 		<td >
 			${color.red} ${color.green} ${color.blue}
		</td >
		<td style ="width:100px;background-color:rgb(${color.red},${color.green},${color.blue})" >&nbsp;
		</td >
	</tr >
</c:forEach >
</table>
</body>
</html>