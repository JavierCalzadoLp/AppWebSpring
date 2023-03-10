<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios Pedidos</title>
</head>
<body>

	
	
	
	<div class="container">
		<h1 >Pedidos por Usuario</h1>
		
		<table >
			<tr >
				<th>ID Pedido</th>
				<th>ID Usuario</th>
				<th>Fecha de pedido</th>
				<th>Calle de entrega</th>
				<th>Localidad</th>
				<th>Codigo postal</th>
				
			</tr>
			<c:forEach var="pedido" items="${listaPedidos}" >
			<tr>
				<td>${pedido.idPedido }</td>
				<td>${pedido.usuario.idUsuario }</td>
				<td>${pedido.fecha }</td>
				<td>${pedido.direccione.calle }</td>
				<td>${pedido.direccione.localidad }</td>
				<td>${pedido.direccione.codigoPostal }</td>
				
				
			</tr>
			</c:forEach>
		
		</table>
	</div>
	<a href="/admin/verUsuarios" class="boton3">Atrás</a>
	
	<style>
	.container {
  max-width: 800px;
  margin: 0 auto;
  font-family: Arial, sans-serif;
  color: #333;
}

h1 {
  text-align: center;
  font-size: 36px;
  margin-bottom: 20px;
}

hr {
  border: none;
  border-top: 2px solid #ddd;
  margin: 30px 0;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 30px;
}

th, td {
  padding: 10px;
  text-align: left;
}

th {
  background-color: #333;
  color: #fff;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

tr:hover {
  background-color: #ddd;
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
        
     	margin-left: 50%;
     
    }

	
	</style>
	
	</body>
</html>