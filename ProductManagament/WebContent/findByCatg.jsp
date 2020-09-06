<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.pojo.Product" %>
        <%@ page import="com.dao.ProductDAO" %>
        <%@ page import="com.dao.ProductDAOImpl" %>
        <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Find By Category</title>
</head>
<body class="mybody">
 
  <%      

   String user =(String) session.getAttribute("name"); %>
     
      
 <% if(user!=null) { if (user.equalsIgnoreCase("admin")) { %>
  <div class="topnav">
  <a href="validLogin.jsp">Home</a>
   <div class="login-container">
    <form action="logout">
    
      <button type="submit">Logout</button>
    </form>
  </div>
</div>
  <% }} %>
  <% if(user==null) {%>
   <div class="topnav">
  <a href="index.jsp">Home</a>
  </div>
  <%} %>
  
  
<br>
 <div class="addp"> 
<%
ProductDAO dao=new ProductDAOImpl();
List<Product> products=dao.findAll();
%>
<form class="well form-horizontal" action="findbyCatg" >
<fieldset>
 
<legend>Find details of Product</legend>
 

<div class="form-group"> 
  <label class="col-md-4 control-label">Select Product Category of product</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="category" class="form-control selectpicker" >
        <option>Select</option>
    
       <% for(Product e:products) {%>
   <option><%=e.getCategory() %></option>
   <%} %>
      </select>
  </div>
</div>
</div>
 
   <div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" >Find Product <span class="glyphicon glyphicon-send"></span></button>
<button type="reset" class="btn btn-warning" >Reset <span class="glyphicon glyphicon-refresh"></span></button>
  </div>
</div>
</fieldset>
 

</form>
</div> 
 

 
</body>
</html>