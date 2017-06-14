<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RegisterCompany</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<style>
		body{
		margin:10px;
		background:url("resources/images/bg1.png");
		background-repeat:no-repeat;
		background-size:1400px 600px ;
		}
	</style>
</head>
<body>

<h2>ADD JOBS</h2>

<c:choose>
            <c:when test="${!empty sessionScope.email}">
                <jsp:include page="loginjsp.jsp"/>
            </c:when>
            <c:otherwise>
                <jsp:include page="logout.jsp"/>
            </c:otherwise>
  </c:choose>



<form:form action="addjob.htm" commandName="job" method="post">

<table>

<tr>
    <td>Job title:</td>
    <td><form:input path="jobTitle" size="30" /> <font color="red"><form:errors path="jobTitle"/></font></td>
</tr>

 <tr>
    <td>Job Description :</td>
    <td><form:input path="jobDescription" size="30" /> <font color="red"><form:errors path="jobDescription"/></font></td>
</tr>

<tr>
    <td>Job Type:</td>
    <td><form:input path="jobType" size="30" /> <font color="red"><form:errors path="jobType"/></font></td>
</tr>

 <tr>
    <td>Experience:</td>
    <td><form:input path="experience" size="30" /> <font color="red"><form:errors path="experience"/></font></td>
</tr>


<tr>
    <td>Skills:</td>
    <td><form:input path="skills" size="30" /> <font color="red"><form:errors path="skills"/></font></td>
</tr>

 <tr>
    <td>Qualification :</td>
    <td><form:input path="qualification" size="30" /> <font color="red"><form:errors path="qualification"/></font></td>
</tr> 

<tr>
    <td>Location:</td>
    <td><form:input path="location" size="30" /> <font color="red"><form:errors path="location"/></font></td>
</tr>


 <tr>
    <td>Industry :</td>
    <td><form:input path="industry" size="30" /> <font color="red"><form:errors path="industry"/></font></td>
</tr>



<tr>
    <form:hidden path="postedBy" size="30" value ="${sessionScope.email}" />
</tr>


<tr>
    <td colspan="2"><input type="submit" value="Add Job" /></td>
    
</tr>
</table>
</form:form>
<button type="button" class="btn-lg"><a href = "homepageCandidate.htm"><b>GO TO YOUR HOMEPAGE</b></button>
</body>
</html>