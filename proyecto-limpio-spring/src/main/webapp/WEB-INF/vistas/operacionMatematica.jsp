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
					<div class="row">
							<c:if test="${empty error}">
							    <div class="row">
							    	El resultado de ${operador}  ${primerNro} y ${segundoNro} da ${resultado} .
							    </div>
							 </c:if>	
					</div>
					
					<c:if test="${not empty error}">
			        	<h4><span>${error}</span></h4>
			        <br>
		        	</c:if>	
				
			</div>
		
				
		</div>
		
		
	</body>
</html>
