<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<?xml version="1.0"?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
	<title>Bootstrap Example</title>
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
		background-size:1400px 600px ;
		}
	.search{
		margin-top:30px;
		margin-left:350px;
	}
	.heading{
		color:white;
		margin-top:-50px;
		margin-left:470px;
		
	}
	.jobApply{
		margin-top:100px;
		margin-left:400px;
	}
	.modal-header, h4, .close {
      background-color: #3973ac;
      color:white !important;
      text-align: center;
      font-size: 30px;
	  
  }
	.fr{
		margin-top:15px;
		margin-left:1220px;
	}
	.login{
		margin-left:20px;
	}
 
	</style>
 </head>
 <body>
	<div id = "container">
		<div class = "fr">
		
  <!-- Trigger the modal with a button -->
  <img src="resources/images/login-icon.jpg" class="img-circle" alt="Cinque Terre" width="100" height="100" id="myBtn">
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="padding:35px 50px">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <form role="form" action = "login.htm" method = "post">
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label>
              <input type="text" class="form-control" name = "email" placeholder="Enter email">
            </div>
            <div class="form-group">
              <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
              <input type="password" class="form-control" name = "password" placeholder="Enter password">
            </div>
          
              <input type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span> Login</button>
              <input type="hidden" name="action" value="login">
               <c:if test="${!empty requestScope.invalidCredentials}">
                <p style="color:red">Invalid credentials</p>
            </c:if>
              
          </form>	
        </div>
        
      
    </div>
  </div> 
</div>
 </div>
		<div class = "heading">
				<h1>GET HIRED</h1>		
		</div>
		<div class="search">
			<form class="navbar-form navbar-left" action="searchJob.htm" method="post">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Job Title" name="search" required/>
					<input type="text" class="form-control" placeholder="Location" name="location" required/>
				</div>
				<input type="submit" class="btn btn-default" value="Submit"/>
				 <input type="hidden" name="action" value="front"/>
			</form>
		 </div>
		 <div class = "jobApply">
			<a href = "addcandidate.htm"><img src="resources/images/postresume.png" class="img-circle" alt="Cinque Terre" width="200" height="200"></a>&nbsp;&nbsp;&nbsp;
			<a href = "addcompany.htm"><img src="resources/images/postjobs.jpeg" class="img-circle" alt="Cinque Terre" width="200" height="200"></a>
		 </div>
	</div>
	<script>
	var invalidCredentials = '${invalidCredentials}';
	
$(document).ready(function(){
	
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
    if(invalidCredentials === 'true'){
    	$("#myModal").modal("show");
    }
});
</script>
 </body>
 </html>
