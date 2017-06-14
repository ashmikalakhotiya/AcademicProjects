<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Created Successfully</title>
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
        New User Created Successfully<br>
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
               <c:if test="${!empty requestScope.error}">
                <p style="color:red">Invalid credentials</p>
            </c:if>
              
          </form>	
        </div>
        
      </div>
    </div>
  </div> 
</div>
 </div>
</body>
<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>
    
</html>