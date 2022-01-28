<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Random random = new Random();
	int randomInt = random.nextInt(3);
	if (randomInt == 0) {
%>		
		<h1>Random value = <%=randomInt%></h1>
<%
	}else if (randomInt == 1) {
%>
		<h1>Random value = <%=randomInt%></h1>
<%
	}else {
%>
		<h1>Random value = <%=randomInt%></h1>
<%
	}
	
%>

<%!
 public int sum(int a, int b) {
	return a+b;
}
%>

<%!
	int compteur=0;
%>


<a href="<%=request.getRequestURI()%>" >click</a><br>

<h1>1+2=<%=sum(1,2) %></h1>
<h1>Compteur = <%=compteur+=1%></h1>

</body>
</html>