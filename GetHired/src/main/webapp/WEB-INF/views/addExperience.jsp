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

<center><h1>ADD EXPERIENCE</h1></center>
<form:form action="addExperience.htm" id= "eventForm" commandName="professionalEx" method="post">
		
			<div class='form-group'>
				<label class='control-label col-sm-4'>Company Name</label>
					<div class='col-sm-8'>
							<form:input path="companyName" type='text' class='form-control' name='companyName' />
							<font color="red"><form:errors path="companyName"/></font>
			</div>
			</div>
			
			<div class='form-group'>
			
				<label class='control-label col-sm-4'>Designation</label>
					<div class='col-sm-8'>
							<form:input path="designation" type='text' class='form-control' name='designation' />
							<font color="red"><form:errors path="designation"/></font>
			</div>
			
			</div>
			
			<div class='form-group'>
			
				<label class='control-label col-sm-4'>Responsibilities</label>
					<div class='col-sm-8'>
							<form:input path="responsibilities" type='text' class='form-control' name='responsibilities' />
							<font color="red"><form:errors path="responsibilities"/></font>
			</div>
			
			</div>
			
			<div class='form-group'>
			
				<label class='control-label col-sm-4'>Start Date</label>
					<div class='col-sm-8'>
						<div class='input-group date' data-provide='datepicker'>
							<form:input path="startDate" type='text' class='form-control' name='startDate' />
							<font color="red"><form:errors path="startDate"/></font>
							<span class ='input-group-addon add-on '>
								<span class ='glyphicon glyphicon-calendar'></span>
							</span>
						</div>
			</div>
			
			</div>
			
				<div class='form-group'>
			
				<label class='control-label col-sm-4'>End Date</label>
					<div class='col-sm-8'>
						<div class='input-group date' data-provide='datepicker'>
							<form:input path="endDate" type='text' class='form-control' name='endDate' />
							<font color="red"><form:errors path="endDate"/></font>
							<span class ='input-group-addon add-on '>
								<span class ='glyphicon glyphicon-calendar'></span>
							</span>
						</div>
			</div>
			
			</div>
	 
		<center>	<button class = 'btn' type="submit">ADD EXPERIENCE</button> </center>
		<input type = 'hidden'  value='${sessionScope.email}' name='email'/>
				
		
		</form:form>
	</div>
		
	<button type="button" class="btn-lg"><a href = "homepageCandidate.htm"><b>GO TO YOUR HOMEPAGE</b></button>	
</body>
<script>
$(document).ready(function() {
    $('#datePicker')
        .datepicker({
            format: 'mm/dd/yyyy'
        })
        .on('changeDate', function(e) {
            // Revalidate the date field
            //$('#eventForm').formValidation('revalidateField', 'attendedFrom');
			alert("change");
        });
});
</script>
</html>