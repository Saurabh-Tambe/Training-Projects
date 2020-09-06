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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>Update Product</title>
 <script>  
$(document).ready(function(){
    $('#selector').on('change', function() {
      if ( this.value == 'price')
      {
        $("#price").show();
        $("#quantity").hide();
      }
      else
      {
    	  $("#quantity").show();
          $("#price").hide();
      }
    });
});
</script>
</head>
<body class="mybody">
 <div class="topnav">
  <a href="validLogin.jsp">Home</a>
  
  <div class="login-container">
    <form action="logout">
    
      <button type="submit">Logout</button>
    </form>
  </div>
</div>
<br>
 <div class="addp"> 
<%
ProductDAO dao=new ProductDAOImpl();
List<Product> products=dao.findAll();
%>
 <form class="well form-horizontal" action="updatebyId" >
<fieldset>
 
<legend>Update details of Product</legend>

 <div class="form-group"> 
  <label class="col-md-4 control-label">Product ID</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="pid" class="form-control selectpicker" >
        <option>Select</option>
    
       <% for(Product e:products) {%>
   <option><%=e.getpId() %></option>
   <%} %>
      </select>
  </div>
</div>
</div>

<div class="form-group"> 
  <label class="col-md-4 control-label">What to update?</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="update" class="form-control selectpicker" id="selector">
    <option>Select</option>
        <option>price</option>
   <option>quantity</option>
      </select>
  </div>
</div>
</div>
  
<div class="form-group" id="price" style="display:none">
  <label class="col-md-4 control-label">Updated Price:</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-usd"></i></span>
  <input  name="updatedPrice" placeholder="Updated Price" class="form-control"  type="number">
    </div>
  </div>
</div>


<div class="form-group" id="quantity" style="display:none">
  <label class="col-md-4 control-label">Updated Quantity</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-equalizer"></i></span>
  <input  name="updatedQuantity" placeholder="Updated Quantity" class="form-control"  type="number">
    </div>
  </div>
</div>
  
  <div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" >Update Product <span class="glyphicon glyphicon-send"></span></button>
<button type="reset" class="btn btn-warning" >Reset <span class="glyphicon glyphicon-refresh"></span></button>
  </div>
</div>
</fieldset>
 

</form>
</div>
</body>
</html>