<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Producto</title>
</head>
<body>

	
	<div class="card">
  <div class="card-body">
    <h1 class="card-title">FORMULARIO ALTA PRODUCTO</h1>
    <h2>${mensaje }</h2>
    <form action="/admin/altaProducto" method="post">
      <div class="form-group">
        <label for="descripcion">Descripción</label>
        <input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Descripción">
      </div>
      <div class="form-group">
        <label for="nombre">Nombre Producto</label>
        <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre Producto">
      </div>
      <div class="form-group">
        <label for="precio">Precio</label>
        <input type="text" class="form-control" name="precio" id="precio" placeholder="Precio">
      </div>
      <div class="form-group">
        <label for="stock">Stock</label>
        <input type="text" class="form-control" name="stock" id="stock" placeholder="Stock">
      </div>
    
      <button type="submit" class="btn1">Nuevo Producto</button>
    
    </form>
  </div>
</div>

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
.btn1{
background-color: #0d6efd;
text-align: center;
color: #fff;

}
	
	</style>

<!--  
<style>

.card {
margin: 20px auto;
max-width: 500px;
border-radius: 10px;
box-shadow: 0px 0px 10px rgba(0,0,0,0.2);
text-align: center;
margin-bottom: 10px;
}

.card-title {
text-align: center;



}

.form-group label {
font-weight: bold;
margin: 2px;
width: 2px;
height: 10px;
}

.form-control {
border-radius: 5px;
box-shadow: 0px 0px 5px rgba(0,0,0,0.2);
}

.btn-primary {
background-color: #007bff;
border-color: #007bff;
margin: 10px;
}

.btn-primary:hover {
background-color: #0069d9;
border-color: #0062cc;
}

.btn-primary:focus, .btn-primary.focus {
box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.5);
}
</style>

-->
	
	

</body>
</html>