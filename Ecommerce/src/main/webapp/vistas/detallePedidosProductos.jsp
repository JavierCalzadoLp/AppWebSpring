<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles pedidos</title>
</head>
<body>

<h1>Detalles PedidosProductos</h1>
<a href="/admin/pedidos" class="boton3">Atrás</a>
    <table border="1">
        <thead>
            <tr>
                <th>Id_Pedido</th>
                <th>Id_Producto</th>
                <th>Unidades</th>  
                <th>Precio Venta</th>     
                <th>Numero Orden</th>
            
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${linea}" var="linea">
                <tr>
                    <td>${linea.pedido.idPedido}</td>
                    <td>${linea.producto.idProducto}</td>
                    <td>${linea.unidades}</td>
                    <td>${linea.precio_venta}</td>
                    <td>${linea.numeroOrden}</td>
                    
                    
                    
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