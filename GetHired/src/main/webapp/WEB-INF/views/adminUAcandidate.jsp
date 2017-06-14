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
    	<h2>CANDIDATE LIST </h2>
    	 <h3>ACADEMIC DETAILS</h3>
        <table border="1" cellpadding="5" cellspacing="5">
            <tr>
                <td><b>USER ID</b></td>
                <td><b>EMAIL ID</b>
       			<td><b>FIRST NAME</b>
       			<td><b>LAST NAME</b>
       			<td><b>DELETE</b>
             
            </tr>
            <c:forEach var="useraccount" items="${ua}">
                <tr>
                	<td>${useraccount.userid}</td>
                	<td>${useraccount.emailID}</td>
                	<td>${useraccount.firstName}</td>
                	<td>${useraccount.lastName}</td>
                	<td><button class = "btn"><a href = 'deletecandidatefinally.htm?userid=${useraccount.userid}&email=${useraccount.emailID}'>DELETE</a></button></td>
                	
                
                </tr>
            </c:forEach>
        </table>

        
        
    </body>
</html>