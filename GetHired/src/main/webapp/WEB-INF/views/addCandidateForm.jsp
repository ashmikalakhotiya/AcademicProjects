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
		background-size:1600px 800px;
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
<h2>Register Candidate</h2>

<form:form action="addcandidate.htm" commandName="candidate" method="post" enctype="multipart/form-data">

<table>
<tr>
    <td>EmailID : </td>
    <td><form:input path="emailID" size="30" required="required"/> <font color="red"><form:errors path="emailID"/></font></td>
</tr>

<tr>
    <td>Password: </td>
    <td><form:password path="password" required="required" name="pass1" id="pass1" size="30" /> <font color="red"><form:errors path="password"/></font></td>
</tr>


<tr>
    <td>Confirm Password:</td>
    <td><form:password path="confirmPassword" required="required" size="30" name="pass2" id="pass2" onkeyup="checkPass(); return false;"/> <font color="red"><form:errors path="confirmPassword"/></font><span id="confirmMessage" class="confirmMessage"></span></td>	 
</tr>

<tr>
    <td>First Name:</td>
    <td><form:input path="firstName" required="required" size="30" /> <font color="red"><form:errors path="firstName"/></font></td>
</tr>

 <tr>
    <td>Last Name :</td>
    <td><form:input path="lastName" required="required" size="30" /> <font color="red"><form:errors path="lastName"/></font></td>
</tr> 

 <tr>
    <td>Contact Number :</td>
    <td><form:input path="phone" required="required" size="30" /> <font color="red"><form:errors path="phone"/></font></td>
</tr> 

 <tr>
    <td>Resume :</td>
    <td><input path="resume" required="required" type="file" name="fileUpload" /></td>
</tr> 


<tr>
    <td colspan="2"><input type="submit" value="Register Candidate" /></td>
</tr>
</table>

</form:form>

</body>
</html>