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
    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Descripcion</th>       
                <th>Detalle</th>
                
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${productos}" var="producto">
                <tr>
                    <td>${producto.idProducto}</td>
                    <td>${producto.nombre}</td>
                    <td>${producto.descripcion}</td>
                    <td><a href="/detalleProducto?id_producto=${producto.idProducto}"class="boton">Detalle</a>
                    <a href="/prueba" class="boton2">Atrás</a></td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    

     
     <style>
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
</style>
 

</body>
</html>