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
	
	<style>
	/* Estilo de formulario */
form {
  width: 500px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f2f2f2;
  border-radius: 5px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);
}

/* Estilo de encabezado */
h1 {
  text-align: center;
  margin-bottom: 20px;
  font-size: 36px;
  color: #555;
}

/* Estilo de input */
input[type="text"],
input[type="submit"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border: none;
  border-radius: 3px;
}

/* Estilo de placeholder */
input::placeholder {
  color: #bbb;
}

/* Estilo de botón */
input[type="submit"] {
  background-color: #0d6efd;
  color: #fff;
  font-size: 18px;
  cursor: pointer;
}

/* Estilo de botón al pasar el mouse */
input[type="submit"]:hover {
  background-color: #0b5ed7;
}
	
	</style>

</body>
</html>