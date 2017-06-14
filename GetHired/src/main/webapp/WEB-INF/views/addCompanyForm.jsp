<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>RegisterCompany</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<style>
		body{
		margin:10px;
		background:url("resources/images/bg1.png");
		background-repeat:no-repeat;
		background-size:1600px 800px ;
		
		}
	</style>
	<script>
	function checkPass()
	{
	    //Store the password field objects into variables ...
	    var pass1 = document.getElementById('pass1');
	    var pass2 = document.getElementById('pass2');
	    //Store the Confimation Message Object ...
	    var message = document.getElementById('confirmMessage');
	    //Set the colors we will be using ...
	    var goodColor = "#66cc66";
	    var badColor = "#ff6666";
	    //Compare the values in the password field 
	    //and the confirmation field
	    if(pass1.value == pass2.value){
	        pass2.style.backgroundColor = goodColor;
	        message.style.color = goodColor;
	        message.innerHTML = "Passwords Match!"
	    }else{

	        pass2.style.backgroundColor = badColor;
	        message.style.color = badColor;
	        message.innerHTML = "Passwords Do Not Match!"
	    }
	}  
	</script>
</head>
<body>

<h2 style = 'color:white'>COMPANY REGISTRATION FORM</h2>
<br/><br/>

<form:form action="addcompany.htm" commandName="cmp" method="post">

<table>
<tr>
    <td><b>EmailID :</b> </td>
    <td><form:input path="emailID" size="30" required="required"/> <font color="red"><form:errors path="emailID"/></font></td>
</tr>

<tr>
    <td><b>Password: </b></td>
    <td><form:password path="password" name="pass1" id="pass1" size="30" required="required" /> <font color="red"><form:errors path="password"/></font></td>
</tr>


<tr>
    <td><b>Confirm Password:</b></td>
    <td><form:password path="confirmPassword" size="30" required="required" name="pass2" id="pass2" onkeyup="checkPass(); return false;"/> <font color="red"><form:errors path="confirmPassword"/></font><span id="confirmMessage" class="confirmMessage"></span></td>	 
</tr>

<tr>
    <td><b>Company Name:</b></td>
    <td><form:input path="companyName" size="30" required="required" /> <font color="red"><form:errors path="companyName"/></font></td>
</tr>

 <tr>
    <td><b>Location:</b></td>
    <td><form:input path="location" size="30" required="required" /> <font color="red"><form:errors path="location"/></font></td>
</tr> 
</table>
<br/>
<button class="btn btn-md" type="submit" value="Register Compnay">Register Company</button>
</form:form>
</body>
</html>