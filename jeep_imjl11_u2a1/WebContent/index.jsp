<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!
	static Date d = new Date();
%>
<%
	int count;
	
	if(application.getAttribute("count") == null){
		count = 0;
		count++;
		application.setAttribute("count", count );
	}
	else{
		count = (Integer)application.getAttribute("count");
		count++;
		application.setAttribute("count", count );
	}
%>


Start time:<%=d%>
<br>
Visitors: <%=count %>
</body>
</html>