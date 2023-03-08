<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>${mensaje}</h1>
	<h1>FORMULARIO EDICIÓN DE ROLE</h1>
	<form action="/admin/modificarRole" method="post">
	<!--  
		 <p><input type="text" name="nombre" value="${usuario.idUsuario }">idUsuario</p> 
		 <p><input type="text" name="nombre" value="${usuario.apellidos }">Apellidos</p> 
		 <p><input type="text" name="nombre" value="${usuario.email }">Email</p> 
		 <p><input type="text" name="nombre" value="${usuario.enabled }">Enabled</p> 
		 <p><input type="text" name="nombre" value="${usuario.fecha_nacimiento }">Fecha</p> 
		 <p><input type="text" name="nombre" value="${usuario.nombre }">Nombre</p> 
		 <p><input type="text" name="nombre" value="${usuario.password }">Password</p> 
		 -->
		<select>
		<option value="${usuario.idRol}">rol_cliente </option>
		<option value="${usuario.idRol}">rol_admin </option>
		</select>
		
		<p><input type="submit" value="Guardar"></p>
		
	
	</form>

</body>
</html>