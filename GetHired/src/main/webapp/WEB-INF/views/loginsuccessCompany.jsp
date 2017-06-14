<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
		body{
		margin:10px;
		background:url("resources/images/bg1.png");
		background-repeat:no-repeat;
		background-size:1400px 600px;
		color:white;
		}
	</style>
</head>
<body>
<h1>WELCOME COMPANY TO YOUR HOMEPAGE</h1>
 <c:choose>
            <c:when test="${!empty sessionScope.email}">
                <jsp:include page="loginjsp.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="logout.jsp"/>
            </c:otherwise>
  </c:choose>
  <br/>
  
  <div class="btn-group">
  	<button type="button" class="btn btn-lg"><a href = "addjob.htm"><b>POST JOBS</b></a></button>
  	<button type="button" class="btn btn-lg"><a href = "appliedjobcandidate.htm?email=${sessionScope.email}"><b>CANDIDATE APPLICATIONS</b></a></button>
  	<button type="button" class="btn btn-lg"><a href = "viewjobscompany.htm?email=${sessionScope.email}"><b>VIEW APPLIED JOBS</b></a></button>
  </div>	
  
 
	
	
</body>
</html>