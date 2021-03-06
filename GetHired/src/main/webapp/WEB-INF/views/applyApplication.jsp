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
		
		table {
            border-collapse: collapse;
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
    	<h2>APPLIED CANDIDATES </h2>
    	<br/>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>JobID</b></td>
                <td><b>CompanyName</b></td>
                <td><b>RECEIVER</b></td>
                <td><b>SENDER</b></td>
                <td><b>PROFILE</b></td>
            
            </tr>
            <c:forEach var="app" items="${apps}">
                <tr>
               		<td>${app.jobID}</td>
                	<td>${app.companyName}</td>
                	<td>${app.receiver}</td>
                	<td>${app.sender}</td>
                	<td><a href = 'viewcandidateprofile.htm?action=${app.sender}' >VIEW PROFILE</a></td>
                </tr>
            </c:forEach>
        </table>
        <button type="button" class="btn-lg"><a href = "homepageCandidate.htm"><b>GO TO YOUR HOMEPAGE</b></button>
    </body>
</html>