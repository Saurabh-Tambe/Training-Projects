<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="design.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body  class="mybody">

<div class="topnav">
  <a href="index.jsp">Home</a>
  
  <div class="login-container">
    <form action="login.jsp">
    
      <button type="submit">Login</button>
    </form>
  </div>
</div>
<div>
<center>
<h1>Product Management</h1>
<br>
<div class="btngrp">

<a href="findById.jsp"><button type="button" class="btn btn-primary btn-block">Find Product By ID</button></a> <br/>
<br><br>
<a href="findByCatg.jsp"><button type="button" class="btn btn-primary btn-block">Find Product By Category</button></a> <br/>
<br><br>
<a href="findAll"><button type="button" class="btn btn-primary btn-block">Find All Products</button></a> <br/>

 
</div>

</center></div>
</body>
</html>