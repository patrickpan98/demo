<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<jsp:useBean id="personne" class="fr.formation.inti.entity.Employee"></jsp:useBean>
<h2>Hello :</h2>
<jsp:setProperty property="firstName" name="personne" value="Aly"></jsp:setProperty>
<jsp:getProperty property="firstName" name="personne"></jsp:getProperty>
</body>

</html>