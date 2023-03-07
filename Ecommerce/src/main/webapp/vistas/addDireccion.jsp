<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir dirección</title>
</head>
<body>
	<h1>Hola</h1>
	<h1>${mensaje }</h1>
	<form action="/newDirection" method="post">
		<input type="text" name="calle" placeholder="Calle, PLaza, Avenida"> 
		<input type="text" name="codigoPostal" placeholder="Codigo postal"> 
		<input type="text" name="letra" placeholder="Letra"> 
		<input type="text" name="localidad" placeholder="Localidad"> 
		<input type="text" name="numero" placeholder="Numero"> 
		<input type="text" name="Piso" placeholder="Piso"> 
		<input type="submit" value="Nueva Direccion">
	</form>
</body>
</html>