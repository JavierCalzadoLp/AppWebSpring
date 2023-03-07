<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
 <!-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> -->

<!DOCTYPE html>
<html>
<head>
    <title>Mi Perfil</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="/resources/static/style/style.css" rel="stylesheet" type="text/css">
  </head>
  
  <body>
      
    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

	<!-- AÑADIR INICIO 
    <jsp:include page="inicio.jsp"></jsp:include>
    -->
    <div id="container" class="container">
     
 	<h4 class="mt-4 text-white">${usuarios.nombre}</h4>
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered table-dark">
				  <thead>
				    <tr>
				      <th scope="col"></th>
				      <th scope="col"></th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <td>Nombre</td>
				      <td>${usuarios.nombre}</td>
				    </tr>
				     <tr>
				      <td>Apellido</td>
				      <td>${usuarios.apellidos}</td>
				    </tr>
				    <tr>
				      <td>Email</td>
				      <td>${usuarios.email}</td>
				    </tr>
				    <tr>
				      <td>email</td>
				      <td>${usuarios.email}</td>
				    </tr>
				    <tr>
				      <td>Fecha nacimiento</td>
				      <td>${usuarios.fechaNacimiento}</td>
				    </tr>
				    
				  </tbody>
				</table>
				
				<!-- AÑADIR BOTON DE AÑADIR TARJETA Y DIRECCIÓN // REVISAR SI TIENEN QUE LLAMARSE COMO LA BBDD-->
				
			</div>
			
	   </div>
	   <div>
	   	  <a class="nav-link ml-2 btn bg-primary text-white col-md-1" href="/">Volver</a>
	   </div>
    </div>
</body>
</html>