<%@page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Infos : User/Employee</title>
</head>

<body>
<jsp:useBean id="emp" class="fr.formation.inti.entity.Employee"></jsp:useBean>
<%-- <jsp:getProperty property="firstName" name="emp"></jsp:getProperty>
<jsp:getProperty property="lastName" name="emp"></jsp:getProperty> --%>

<%@include file="jspf/header.html" %>
<h3>${message}</h3>
<h4>${user}</h4>
<h4>${employee}</h4>
<a href="<%=request.getContextPath()%>">Retour accueil</a>
<%@include file="jspf/footer.html" %>
</body>

</html>