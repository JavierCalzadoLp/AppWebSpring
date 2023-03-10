<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
</head>
<body>
	<h1>Registro Administrador</h1>
	<h1>${mensaje }</h1>
	<form action="/admin/registro" method="post">
		<input type="text" name="email" placeholder="Email"> <input
			type="text" name="password" placeholder="Contraseña"> <input
			type="text" name="nombre" placeholder="Nombre"> <input
			type="text" name="apellidos" placeholder="Apellidos"> <input
			type="text" name="fechaNacimiento" placeholder="yyyy-mm-dd"> <input
			type="submit" value="Registrarse">
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