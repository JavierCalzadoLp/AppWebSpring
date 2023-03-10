<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nueva Tarjeta</title>
</head>
<body>
	<h1>Añadir Tarjeta Bancaria</h1>
	<h1>${mensaje }</h1>
	<form action="/usuarios/addTarjeta" method="post">
		<input type="text" name="nombreTitular" placeholder="Nombre del Titular"> <input
			type="text" name="numTarjeta" placeholder="Numero de la Tarjeta"> <input
			type="text" name="fechaCaducidad" placeholder="Fecha de Caducidad"> <input
			type="text" name="cvv" placeholder="CVV"> <input
			type="submit" value="Nueva Tarjeta">
	</form>
	
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
	
	</style>
</body>
</html>