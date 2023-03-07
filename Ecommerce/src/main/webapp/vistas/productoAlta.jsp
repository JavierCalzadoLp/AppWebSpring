<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Producto</title>
</head>
<body>
	<h1>Hola</h1>
	<h1>${mensaje }</h1>
	<form action="/addProducto" method="post">
		<input type="text" name="descripcion" placeholder="Descripcion"> <input
			type="text" name="nombre" placeholder="Nombre Producto"> <input
			type="text" name="precio" placeholder="Precio"> <input
			type="text" name="stock" placeholder="Stock"> <input
			type="submit" value="Nuevo Producto">
	</form>
</body>
</html>