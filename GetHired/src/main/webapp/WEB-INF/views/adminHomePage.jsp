<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Insert title here</title>
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

 <c:choose>
            <c:when test="${!empty sessionScope.email}">
                <jsp:include page="loginjsp.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="logout.jsp"/>
            </c:otherwise>
  </c:choose>
  	<br/>
  	<br/>
  	<div class="btn-group">
  	<h1> ADMIN HOME PAGE </h1>
  	<button type="button" class="btn"><a href = "deleteCompany.htm"><b>DELETE COMPANY</b></button>
  	<button type="button" class="btn"><a href = "deleteCandidate.htm"><b>DELETE CANDIDATE</b></button>
	</div>
  	
  	
 
</body>
</html>