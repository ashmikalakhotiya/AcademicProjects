<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
		body{
		margin:10px;
		background:url("resources/images/bg1.png");
		background-repeat:no-repeat;
		background-size:1600px 800px;
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
  
	<p>You have successfully applied for the job </p>
	
<button type="button" class="btn-lg"><a href = "lookjob.htm"><b>VIEW MORE JOBS</b></button>
<button type="button" class="btn-lg"><a href = "homepageCandidate.htm"><b>GO TO YOUR HOMEPAGE</b></button>
	
	
</body>
</html>