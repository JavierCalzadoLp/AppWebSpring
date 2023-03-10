<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Pedidos</title>
</head>
<body>
<h1>LISTADO DE PEDIDOS</h1>
<div class="form">


 <form action="/admin/ordenarPedidos" method="get">
    <label for="ordenarPor">Ordenar por:</label>
    <select name="ordenarPor" id="ordenarPor">
        <option value="fecha">Fecha</option>
    </select>
    <button type="submit">Ordenar</button>
</form>
</div>

<a href="/" class="boton3">Atrás</a>



    <table border="1">
        <thead>
            <tr>
                <th>Id_Pedido</th>
                <th>Fecha</th>
                <th>Id_Direccion</th>  
                <th>Id_Tarjeta</th>     
                <th>Id_Usuario</th>
                <th>Estado</th>
                <th>Detalles</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${pedido}" var="pedido">
                <tr>
                    <td>${pedido.idPedido}</td>
                    <td>${pedido.fecha}</td>
                    <td>${pedido.direccione}</td>
                    <td>${pedido.tarjeta.idTarjeta}</td>
                    <td>${pedido.usuario.idUsuario}</td>
                    <td>${pedido.estado}</td>
                    <td><a href="/admin/detallesPedidos/${pedido.idPedido }"class="boton">Detalle</a>
                    
                    
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

</body>
</html>