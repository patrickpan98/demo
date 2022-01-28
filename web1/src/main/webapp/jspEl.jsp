<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>El : Expression language</title>
<link href="./styles/loginStyle.css" rel="stylesheet" id="bootstrap-css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
<jsp:useBean id="emp" class="fr.formation.inti.entity.Employee"></jsp:useBean>

<div class="wrapper fadeInDown">
  <div id="formContent">
	<!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="https://cdn.signavio.com/uploads/2020/08/logo-inti-web.png" id="icon" alt="User Icon" />
      <br>
      <b style="color: red;">${message}</b>
    </div>
	
    <!-- Login Form -->
    <form action="user" method="post">
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
      <input type="password" id="password" class="fadeIn second" name="password" placeholder="password">
      <br>
      <input type="submit" class="fadeIn third" value="Log In">
    </form>
    
    <!-- Inscription -->
    <div id="formFooter">
      <a class="underlineHover" href="register.jsp">S'inscrire</a>
    </div>

  </div>
</div>
</body>

</html>