<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles del producto</title>
</head>
<body>

<h1>Detalles del producto</h1>



<div class="producto-card">
  <h2>${producto.nombre}</h2>
  
  <div class="producto-info">
    <p>${producto.descripcion}</p>
    <p>Precio: ${producto.precio}</p>
    <p>Stock: ${producto.stock}</p>
    <a href="/todosProductos" class="btn btn-primary">Volver</a>
  </div>
</div>

<style>
h1{
	font-family: "Montserrat", sans-serif;
	text-align: center;
}
.producto-card {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #f2f2f2;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
  width: 300px;
  margin: 20px auto;
}

.producto-card h2 {
  font-size: 24px;
  font-family: "Montserrat", sans-serif;
  margin-bottom: 10px;
  text-align: center;
}

.producto-info {
  margin-top: 20px;
  text-align: center;
}

.producto-info p {
  font-size: 18px;
  font-family: "Roboto", sans-serif;
  margin-bottom: 10px;
}

.btn-primary {
  display: inline-block;
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border-radius: 5px;
  text-decoration: none;
  margin-top: 20px;
  font-size: 18px;
  font-family: "Montserrat", sans-serif;
}

.btn-primary:hover {
  background-color: #0069d9;
}

.btn-volver {
  display: inline-block;
  background-color: #dc3545;
  color: #fff;
  padding: 10px 20px;
  border-radius: 5px;
  text-decoration: none;
  margin-top: 20px;
  font-size: 18px;
  font-family: "Montserrat", sans-serif;
}

.btn-volver:hover {
  background-color: #c82333;
}


</style>

</body>
</html>