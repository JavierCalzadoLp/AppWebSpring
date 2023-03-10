<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de productos</title>
</head>
<body>

 <h1>Lista de productos</h1>
 <div class="form">
 <form action="/ordenarProductos" method="get">
    <label for="ordenarPor">Ordenar por:</label>
    <select name="ordenarPor" id="ordenarPor">
        <option value="id_producto">ID</option>
        <option value="nombre">Nombre</option>
        <option value="descripcion">Descripción</option>
        <option value="precio">Precio</option>
    </select>
    <button type="submit">Ordenar</button>
</form>
</div>
<div class="form">
<form action="/buscarProductos" method="get">
    <label for="busqueda">Buscar:</label>
    <input type="text" name="busqueda" id="busqueda">
    <button type="submit">Buscar</button>
</form>
</div>
 
 <a href="/" class="boton3">Atrás</a>
    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Descripcion</th>  
                <th>Precio</th>     
                <th>Detalle</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${productos}" var="producto">
                <tr>
                    <td>${producto.idProducto}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.descripcion}</td>
                    <td>${producto.precio}</td>
                    <td><a href="/detalleProducto?id_producto=${producto.idProducto}"class="boton">Detalle</a>
                    <a href="/usuarios/anadirUno/${producto.idProducto }" class="boton2">Añadir al carrito</a></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    

     
     <style>
     
     .form{
     text-align: center;
     }
     
     h1 {
  font-family: "Arial", sans-serif;
  font-size: 36px;
  text-align: center;
  margin-top: 40px;
}
    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #f5f5f5;
        font-family: Arial, sans-serif;
        /* font-family: Montserrat, cursive; */
        font-size: 14px;
        margin: 40px auto;
        max-width: 1000px;
    }

    th {
        background-color: #d1d1d1;
        color: #555;
        font-weight: bold;
        text-align: left;
        padding: 10px;
    }

    td {
        padding: 10px;
    }

    tr:nth-child(even) {
        background-color: #e0e0e0;
    }

    tr:hover {
        background-color: #ccc;
    }

    .boton {
        display: inline-block;
        padding: 8px 16px;
        font-size: 14px;
        font-weight: bold;
        text-decoration: none;
        text-align: center;
        border: none;
        border-radius: 4px;
        color: #fff;
        background-color: #4caf50;
        cursor: pointer;
        }
        
      .boton2 {
        display: inline-block;
        padding: 8px 16px;
        font-size: 14px;
        font-weight: bold;
        text-decoration: none;
        text-align: center;
        border: none;
        border-radius: 4px;
        color: #fff;
        background-color: #0000ff;
        cursor: pointer;
    }
    .boton3 {
        display: inline-block;
        padding: 8px 16px;
        font-size: 14px;
        font-weight: bold;
        text-decoration: none;
        text-align: center;
        border: none;
        border-radius: 4px;
        color: #fff;
        background-color: #ff0000;
        cursor: pointer;
        
     	margin-left: 120px;
     
    }
</style>

<!-- 
ESTO ES PARA AÑADIR EL MENU TAMBIEN EN EL RESTO DE PAGINAS

<header style="border: 1px solid black;">
		<nav>
			<ul style="justify-content: center">
				<li><a href=/inicio>Home</a></li>
				<li><a href=/todosProductos>Productos</a></li>
				<li><a href=#>Servicios</a></li>
				<li><a href=#>Carrito</a></li>
				<li><a href=#>Registrarse</a></li>
				<li><a href=#><button>Iniciar sesión</button></a></li>
			</ul>
		</nav>
		<style>
		nav ul {
			margin: 0;
			padding: 0;
			list-style: none;
			text-align: center;
			background-color: #f2f2f2;
		}
		
		nav ul li {
			display: inline-block;
			margin:  10px;
		}
		
		nav ul li a {
			display: block;
			padding: 10px 20px;
			color: #555;
			text-decoration: none;
			font-size: 18px;
			font-weight: bold;
			transition: color 0.3s ease-in-out;
		}
		
		nav ul li a:hover {
			color: #007bff;
		}
		
		section {
			margin: 40px;
		}
		button {
		
				background-color: #007bff;
				color: white;
				border: none;
  				border-radius: 5px; 
  				padding: 10px 20px; 
  				text-align: center; 
  				text-decoration: none;
  				display: inline-block;
  				font-size: 16px; 
 	 			margin: 5px;
  				cursor: pointer;
  				transition: background-color 0.3s;
		
		}
		
	</style>
	</header>
 -->
 

</body>
</html>