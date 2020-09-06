<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.pojo.Product" %>
     <%@ page import="java.util.List" %>
     <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Display Products</title>
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
 <div class="disp"> 
<%
List<Product> list=(List<Product>) request.getAttribute("prod");
 

%>
<% String user1 =(String) session.getAttribute("name"); %>
     
      
 <% if(user1!=null) { if (user1.equalsIgnoreCase("admin")) { %>

<table border=1 class="table table-striped">
<h3>Details of all Products:</h3>
 <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Product Quantity</th>
        <th>Product Category</th>
        <th>   </th>
        <th>   </th>
      </tr>
    </thead>
<core:forEach items="${prod}" var="prod">
<tr class="info">
<td>${prod.pId }</td>
<td> ${prod.pName }</td>
<td>${prod.price }</td>
<td>${prod.quantity }</td>
<td>${prod.category }</td>
<td><a href="deleteData?pid=${prod.pId }">Delete Record</a></td>
<td><a href="updateById.jsp?pid=${prod.pId }">Update Record</a></td>

</tr>
 
</core:forEach>


</table>

<%} }else{%>
<table border=1 class="table table-striped">
<h3>Details of all Products:</h3>
 <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Product Quantity</th>
        <th>Product Category</th>
         
      </tr>
    </thead>
<core:forEach items="${prod}" var="prod">
<tr class="info">
<td>${prod.pId }</td>
<td> ${prod.pName }</td>
<td>${prod.price }</td>
<td>${prod.quantity }</td>
<td>${prod.category }</td>
 

</tr>
 
</core:forEach>


</table>


	<%
    } %>  
</div>
</body>
</html>