<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Total pedido</title>
</head>
<body>



<div class ="container" >
    <h3>Total Pedido</h3>
    <hr>

    <table >
        <tr>
            <th>Producto</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
        </tr>
            <c:forEach items="${carrito}" var="c">
                <c:set var="subtotal" value="${c.key.precio * c.value}"/>
                <tr>
                    <td>${c.key.descripcion}</td>
                    <td>${c.key.precio}</td>
                    <td>${c.value}</td>
                    <td>${subtotal}</td>
                </tr>
                <c:set var="total" value="${total + subtotal}"/>
            </c:forEach>
            <tr>
                <td colspan ="4" style="text-align: right"><strong>TOTAL: ${total}</strong></td>
            </tr>
    </table>
    <form action="/usuarios/compraCompletada" method="GET">
        <div  style="max-width: 50%">
            
            <h4><label >Direccion</label></h4>
                <select  name="idDireccion">
                    <option selected>Selecciona tu calle</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value=${d.idDireccion}>${d.calle}</option>
                    </c:forEach>
                </select>
                <select   >
                    <option selected>Selecciona tu numero</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value="0">${d.numero}</option>
                    </c:forEach>
                </select>
                <select  >
                    <option selected>Selecciona localidad</option>
                    <c:forEach items="${user.direcciones}" var="d">
                        <option value="0">${d.localidad}</option>
                    </c:forEach>
                </select>
            <h4><label >Metodo de pago</label></h4>
                <select  name="idTarjeta">
                    <option selected>Titular</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value=${t.idTarjeta}>${t.nombreTitular}</option>
                    </c:forEach>
                </select>
                <select  >
                    <option selected>Numero de tarjeta</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value="0">${t.numTarjeta}</option>
                    </c:forEach>
                </select>
                <select  >
                    <option selected>CVV</option>
                    <c:forEach items="${user.tarjetas}" var="t">
                        <option value="0">${t.cvv}</option>
                    </c:forEach>
                </select>
                <input type ="submit"  value ="Pagar">
                
        </div>
    </form>
    <h2>${error}</h2>
</div>

<style>

.container {
  margin: 0 auto;
  max-width: 960px;
  padding: 0 15px;
}

table {
  width: 100%;
  margin-bottom: 1rem;
  background-color: #fff;
  border-collapse: collapse;
}

th, td {
  padding: 0.75rem;
  text-align: left;
  border: 1px solid #ddd;
}

th {
  background-color: #f2f2f2;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

tr:hover {
  background-color: #ddd;
}

h3 {
  margin-top: 0;
}

form {
  margin-top: 2rem;
}

h2 {
  margin-top: 0;
}

label {
  display: block;
  margin-bottom: 0.5rem;
}

select {
  display: block;
  width: 100%;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
  transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
  margin-bottom: 1rem;
}

select:focus {
  color: #495057;
  background-color: #fff;
  border-color: #80bdff;
  outline: 0;
  box-shadow: 0 0 0 0.2rem rgba(0, 123, 255, 0.25);
}

input[type="submit"] {
  display: inline-block;
  font-weight: 400;
  color: #fff;
  text-align: center;
  vertical-align: middle;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
  background-color: #007bff;
  border: 1px solid #007bff;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  line-height: 1.5;
  border-radius: 0.25rem;
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out, border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
  cursor: pointer;
}

input[type="submit"]:focus, input[type="submit"]:hover {
  color: #fff;
  background-color: #0069d9;
  border-color: #0062cc;
}

.btn-primary {
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}

.btn-primary:focus, .btn-primary:hover {
  color: #fff;
  background-color: #0069d9;
  border-color: #0062cc;
}

.btn-primary:active {
  color: #fff;
  background-color: #0062cc;
  border-color: #005cbf;
}

.btn-primary:disabled {
  color: #fff;
  background-color: #007bff;
  border-color: #007bff;
}


</style>

</body>
</html>