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
	<h1>FORMULARIO EDICIÓN DE PRODUCTO</h1>
	<form action="/admin/modificar" method="post">
		<p><input type="text" name="id_producto" value="${producto.idProducto }">ID</p>
		<p><input type="text" name="nombre" value="${producto.nombre }">Nombre</p>
		<p><input type="text" name="descripcion" value="${producto.descripcion }">Descripcion</p>
		<p><input type="text" name="precio" value="${producto.precio }">Precio Unidad</p>
		<p><input type="text" name="stock" value="${producto.stock }">Stock</p>
		
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