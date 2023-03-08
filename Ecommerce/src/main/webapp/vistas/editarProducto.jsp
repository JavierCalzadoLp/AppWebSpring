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
	<h1>FORMULARIO EDICCION DE PRODUCTO</h1>
	<form action="/admin/modificar" method="post">
		<p><input type="text" name="nombre" value="${producto.nombre }">Nombre</p>
		<p><input type="text" name="descripcion" value="${producto.descripcion }">Descripcion</p>
		<p><input type="text" name="precio" value="${producto.precio }">Precio Unidad</p>
		<p><input type="text" name="stock" value="${producto.stock }">Stock</p>
		
		<p><input type="submit" value="Guardar"></p>
		
	
	</form>
</body>
</html>