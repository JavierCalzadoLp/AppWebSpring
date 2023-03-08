<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Producto</title>
</head>
<body>

	
	<div class="card">
  <div class="card-body">
    <h2 class="card-title">FORMULARIO ALTA PRODUCTO</h2>
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
      <button type="submit" class="btn btn-primary">Nuevo Producto</button>
     
    </form>
  </div>
</div>

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


	
	

</body>
</html>