<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito de la compra</title>

</head>
<body>
	

	
	<div class="container">
	<h1 >Productos del carrito</h1>

	
	
    <table >
      <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Descripcion</th>
        <th>Cantidad</th>
        <th>Modificar Unidades</th>
      </tr>
      <c:if test="${not empty carrito}">
        <c:forEach items="${carrito}" var="entry">
          <tr>
            <td>${entry.key.idProducto}</td>
            <td>${entry.key.nombre}</td>
            <td>${entry.key.descripcion}</td>
            <td>${entry.value}</td>
            <td>
            	<a href="/usuarios/anadirUno/${entry.key.idProducto}" >Anadir</a>
            	<a href="/usuarios/eliminarUno/${entry.key.idProducto}" >Restar</a>
            </td>
          </tr>
        </c:forEach>
      </c:if>
      <c:if test="${empty carrito}">
        <tr>
          <td colspan="2">No hay items en el carrito</td>
        </tr>
      </c:if>
    </table>
        

        <a href="/usuarios/guardar">Guardar Carrito</a>
        <a href ="/usuarios/comprar" >Hacer pedido</a>
        <a href="/" class="boton3">Atras</a>
    </div>
    
    <style>
    
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
        
     
    }
   .container {
  font-family: Arial, sans-serif;
  max-width: 960px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px;
}

table th,
table td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ccc;
}

table th {
  text-transform: uppercase;
  background-color: #eee;
}

table tr:hover td {
  background-color: #f9f9f9;
}

table td a {
  display: inline-block;
  margin-right: 10px;
  padding: 5px 10px;
  border-radius: 5px;
  text-decoration: none;
  font-weight: bold;
  color: #fff;
}

table td a.add {
  background-color: #4CAF50;
}

table td a.remove {
  background-color: #f44336;
}

a {
  display: block;
  margin-top: 20px;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #4CAF50;
  color: #fff;
  font-weight: bold;
  text-decoration: none;
  cursor: pointer;
}

a:hover {
  background-color: #3e8e41;
}
   
    </style>
    
    
	
</body>
</html>