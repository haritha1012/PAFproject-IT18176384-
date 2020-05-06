<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.Registration"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/Registration.js"></script>
	<meta charset="ISO-8859-1">

	<meta charset="ISO-8859-1">
	<title>Registration page</title>


	<div class="container">
		<div class="row">
			<div class="col-8">

				<h1>Registration</h1>
				<form id="regUser" name="regUser" method="post" action="Registration.jsp">
					UserID:
					<input id="userid" name="userid" type="text"class="form-control">
					
					 <br> First Name:
					<input id="fname" name="FName" type="text"class="form-control"> 
					
					 <br> Last Name: 
					<input id="lname" name="Lname" type="text"class="form-control"> 
					
					 <br> Address: 
					<input id="address" name="address" type="text"class="form-control">
					
					 <br> Date of Birth:
					<input id="DoB" name="DoB" type="Date" class="form-control">
					
					 <br> Phone No.:
					<input id="phone" name="Phone" type="text" class="form-control">
					
					 <br> E mail:
					<input id="email" name="Email" type="text" class="form-control">
					<br>
					<br>
					<input id="regbtn" name="Regbtn" type="submit" value="Register"class="btn btn-primary">
					<input id="resetbtn" name="Resetbtn" type="reset" value="Reset" class="btn btn-danger">
					<input id="deletebtn" name="deletebtn" type="reset" value="Delete" class="btn btn-warning">
					<input id="updatebtn" name="updatebtn" type="submit" value="Update" class="btn btn-success">
					
				</form>


				<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
  
   <br>
 <div id="divRegistration">
   
   <%
   
      Registration reg = new Registration();
      out.print(reg.readReg());
   %>
   </div>
	
			</div>
		</div>
	</div>
</body>
</html>