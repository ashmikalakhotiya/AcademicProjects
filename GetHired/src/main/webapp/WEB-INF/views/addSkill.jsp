<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Part4</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
		<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<style>
		body{
		margin:10px;
		background:url("resources/images/bg1.png");
		background-repeat:no-repeat;
		background-size:1400px 600px ;
		color:white;
		}
	</style>
	</head>
<body>
	<c:choose>
            <c:when test="${!empty sessionScope.email}">
                <jsp:include page="loginjsp.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="logout.jsp"/>
            </c:otherwise>
  </c:choose>
<div class = 'container'>	

<center><h1>ADD SKILL</h1></center>
<form:form action="addSkill.htm" commandName="skill" method="post">
		
			<div class='form-group'>
				<label class='control-label col-sm-4'>Skill Name</label>
					<div class='col-sm-8'>
							<form:input path="skillname" type='text' class='form-control' name='skillname' />
							<font color="red"><form:errors path="skillname"/></font>
			</div>
			</div>
			
			<div class='form-group'>
			
				<label class='control-label col-sm-4'>Proficiency Level</label>
					<div class='col-sm-8'>
							5<label class='radio-inline'><form:radiobutton class='form-control' path='proficiency' name='proficiency' value='5' /></label>
							4<label class='radio-inline'><form:radiobutton class='form-control' path='proficiency' name='proficiency' value='4' /></label>
							3<label class='radio-inline'><form:radiobutton class='form-control' path='proficiency' name='proficiency' value='3' /></label>
							2<label class='radio-inline'><form:radiobutton class='form-control' path='proficiency' name='proficiency' value='2' /></label>
							1<label class='radio-inline'><form:radiobutton class='form-control' path='proficiency' name='proficiency' value='1' /></label>
							
							<font color="red"><form:errors path="proficiency"/></font>
			</div>
			
			</div>
			
		<center>	<button class = 'btn' type="submit">ADD SKILL</button> </center>
		
				<input type = 'hidden'  value='${sessionScope.email}' name='email'/>
				<input type = 'hidden'  value='${sessionScope.userid}' name='user'/>
		
		</form:form>
	</div>
		<button type="button" class="btn-lg"><a href = "homepageCandidate.htm"><b>GO TO YOUR HOMEPAGE</b></button>
		
</body>
</html>