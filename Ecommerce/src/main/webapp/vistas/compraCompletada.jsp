<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Pedido completado</title>
</head>
<body>


<div class ="container2">
    
    <a href="/todosProductos">Ver productos</a>
    <a href="/" >Volver a pagina principal</a>
</div>
<div class ="container">

    
    <img src="<c:url value="/images/compra.jpg" />" alt="Image" style="width: 800px; height: 800px;"> 

   
</div>


<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.container2 {
  display: flex;
  justify-content: center;
  margin-top: 30px;
}

a {
  display: inline-block;
  margin: 0 10px;
  padding: 10px 20px;
  border: none;
  border-radius: 20px;
  font-size: 18px;
  font-weight: bold;
  text-decoration: none;
  text-align: center;
  color: #fff;
  background-color: #0099ff;
}

a:hover {
  background-color: #007acc;
}

a:active {
  background-color: #005299;
}

img {
  display: block;
  margin: 0 auto;
  max-width: 100%;
  height: auto;
}

</style>

</body>
</html>