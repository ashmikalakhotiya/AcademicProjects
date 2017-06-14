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
		background-size:1800px 800px;
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
    	<h2>PROFILE OF THE CANDIDATE </h2>
    	 <h3>ACADEMIC DETAILS</h3>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>SCHOOL NAME</b></td>
                <td><b>DEGREE NAME</b>
                <td><b>MAJOR</b>
                <td><b>ATTENDED FROM</b>
                <td><b>ATTENDED TO</b>
             
            </tr>
            <c:forEach var="education" items="${education}">
                <tr>
                	<td>${education.schoolName}</td>
                	<td>${education.degreeName}</td>
                	<td>${education.major}</td>
                	<td>${education.attendedFrom}</td>
                	<td>${education.attendedTo}</td>
                </tr>
            </c:forEach>
        </table>
        <h3>PROFESSIONAL EXPERIENCE</h3>
        	
                <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>COMPANY NAME</b></td>
                <td><b>DESIGNATION</b>
                <td><b>RESPONSIBILITIES</b>
                <td><b>START DATE</b>
                <td><b>END DATE</b>
             
            </tr>
            <c:forEach var="experience" items="${experience}">
                <tr>
                	<td>${experience.companyName}</td>
                	<td>${experience.designation}</td>
                	<td>${experience.responsibilities}</td>
                	<td>${experience.startDate}</td>
                	<td>${experience.endDate}</td>
                </tr>
            </c:forEach>
        </table>
        
        <h3>SKILL SET</h3>
        	
                <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>SKILL NAME</b></td>
                <td><b>PROFICIENCY LEVEL</b>
            </tr>
            <c:forEach var="skill" items="${skill}">
                <tr>
                	<td>${skill.skillname}</td>
                	<td>${skill.proficiency}</td>
                </tr>
            </c:forEach>
        </table>
        
        <button type="button" class="btn-lg"><a href = "homepageCandidate.htm"><b>GO TO YOUR HOMEPAGE</b></button>
    </body>
</html>