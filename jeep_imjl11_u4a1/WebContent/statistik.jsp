<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:useBean id="stats" class="statistic.Statistik" scope="request">
	 <jsp:setProperty name="stats" property="*" />
</jsp:useBean>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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