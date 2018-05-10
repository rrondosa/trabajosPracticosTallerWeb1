<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Placed at the end of the document so the pages load faster -->
		<script src="js/jquery-1.11.3.min.js" ></script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			    	<h3 class="form-signin-heading">Suma de numeros:</h3>
					<hr class="colorgraph"><br>
				<form action="">
					
					
					<div class="row">
						<div class="span12">
							
						    
						    <div class="row">
						    	<div class="span6">${a} +  ${b} =</div>
						      	<div class="span6">${resultado} </div>
						    </div>
						
						</div>
					</div>
				</form>
				
			</div>
		
	
	
		
			
				
				
				
				
				
				
				<%--<form:form action="validar-login" method="POST" modelAttribute="usuario">

					Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados
					
					<form:input path="email" id="email" type="email" class="form-control" />
					
					<form:input path="password" type="password" id="password" class="form-control"/>     		  
					
					<button class="btn btn-lg btn-primary btn-block" Type="Submit">Login</button> 
				</form:form>--%>
				

				
		</div>
		
		
	</body>
</html>
