<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="stats" class="stat.Statistik" scope="application">	
</jsp:useBean>		
</head>
<body>
<h1>Browser:</h1>
<c:forEach var="key" items="${ stats.statistic1 }">
				<c:out value="${ key }" />
				<c:out value="${ statistic[key] }" /><br/>
</c:forEach>

<h1>OS:</h1>
<c:forEach var="key" items="${ stats.statistic2 }">
				<c:out value="${ key }" />
				<c:out value="${ statistic[key] }" /><br/>
</c:forEach>

</body>
</html>