<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Tarjeta</title>
</head>
<body>
	<h1>Hola</h1>
	<h1>${mensaje }</h1>
	<form action="/newTarjeta" method="post">
		<input type="text" name="nombreTitular" placeholder="Nombre del Titular"> <input
			type="text" name="numTarjeta" placeholder="Numero de la Tarjeta"> <input
			type="text" name="fechaCaducidad" placeholder="Fecha de Caducidad"> <input
			type="text" name="cvv" placeholder="CVV"> <input
			type="submit" value="Nueva Tarjeta">
	</form>
</body>
</html>