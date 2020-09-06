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
<script type="text/javascript">
function validate()
{
	var user = document.getElementById("uname");
	var pass = document.getElementById("psw");
	
	if(user.value=="admin" && pass.value=="1234")
		{
		return true;
		}
	else
		{
		alert("Invalid Username and Password!!");
		return false;
		}
	
}
</script>


</head>
<body class="mybody">
<div class="topnav">
  <a href="index.jsp">Home</a>
 
</div>
<br/><br/>
<div class="loginform">
<form action="login" onsubmit="return validate()" class="well form-horizontal" >
<fieldset>
<legend>Login</legend>


<div class="form-group">
  <label class="col-md-4 control-label">Username</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
           <input type="text" placeholder="Enter Username" class="form-control" id="uname" name="uname" required>
    </div>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Password</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
        <input type="password" placeholder="Enter Password" class="form-control" id="psw" name="psw" required>
    </div>
  </div>
</div>
 
<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button type="submit" class="btn btn-warning" >Login <span class="glyphicon glyphicon-send"></span></button>
<button type="reset" class="btn btn-warning" >Reset <span class="glyphicon glyphicon-send"></span></button>
  </div>
</div>
</fieldset>
 
   
 
        
</form> 
    </div>
</body>
</html>