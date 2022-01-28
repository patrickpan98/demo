<%@page errorPage="error.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link href="./styles/loginStyle.css" rel="stylesheet" id="bootstrap-css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
  	<b style="color: red;">${message}</b>
	<form action="register" method="post">
		<input type="text" id="firstname" class="fadeIn second" name="firstname" placeholder="firstname"> 
		<input type="text" id="lastname" class="fadeIn second" name="lastname" placeholder="lastname">
      	<input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
      	<input type="password" id="password" class="fadeIn second" name="password" placeholder="password">
      	<input type="password" id="password2" class="fadeIn second" name="password2" placeholder="password again">
		<br>
		<input type="submit" class="fadeIn third" value="Register">
	</form>
	<a href="<%=request.getContextPath()%>">Retour accueil</a>
  </div>
</div>
</body>

</html>