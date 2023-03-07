<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ecommerce - Inicio</title>
	<!--  <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"> -->
</head>
<body>
	<header style="border: 1px solid black;">
		<nav>
			<ul style="justify-content: center">
				<li><a href="<spring:url value="#" />">Inicio</a></li>
				<li><a href="<spring:url value="/todosProductos" />">Productos</a></li>
				<li><a href="<spring:url value="#" />">Servicios</a></li>
				<li><a href="<spring:url value="#" />">Carrito</a></li>
				<li><a href="<spring:url value="#" />">Registro</a></li>
				<li><a href="<spring:url value="#" />"><button>Iniciar sesión</button></a></li>
			</ul>
		</nav>
	</header>
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
	
	<main style="border: 1px solid black">
		
		
	<section class="hero">
  <div class="hero-container">
    <div class="hero-text">
      <h1>Bienvenido a nuestra tienda</h1>
      <p>Regístrese para recibir nuestras últimas noticias y ofertas especiales</p>
      <a href="#" class="button"><button> Registrarse </button></a>
    </div>
    <div class="hero-image">
      <img src="<c:url value="/images/image3.jpg" />" alt="Hero Image" style="width: 600px; height: 400px;"> 
      <!-- style="width: 800px; height: 500px;" -->
    </div>
  </div>
</section>

<style>
.hero-container {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}

.hero-text {
 	max-width: 50%;
  font-size: 30px;
}

.hero-image {
  max-width: 70%;
  margin-left: 3em;
}


  .hero-text,
  .hero-image {
    max-width: 100%;
    margin: 0;
    text-align: left;
  }
}
</style>
	
	
		
		


	<main>
		<div class="container">
			<div class="product">
				<img src="<c:url value='/images/image1.jpg' />" alt="Producto 1">
				<h3>Producto 1</h3>
				<p>Nike Style Black/Red/White</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image2.jpg' />" alt="Producto 2">
				<h3>Producto 2</h3>
				<p>Nike Air Force White</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image3.jpg' />" alt="Producto 3">
				<h3>Producto 3</h3>
				<p>Nike Air Force Style Consectetur.</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image4.jpg' />" alt="Producto 3">
				<h3>Producto 4</h3>
				<p>Converse All Star</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image5.jpg' />" alt="Producto 3">
				<h3>Producto 4</h3>
				<p>Converse All Star</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image6.jpg' />" alt="Producto 3">
				<h3>Producto 4</h3>
				<p>Converse All Star</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image7.jpg' />" alt="Producto 3">
				<h3>Producto 4</h3>
				<p>Converse All Star</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image8.jpg' />" alt="Producto 3">
				<h3>Producto 4</h3>
				<p>Converse All Star</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
			<div class="product">
				<img src="<c:url value='/images/image9.jpg' />" alt="Producto 3">
				<h3>Producto 4</h3>
				<p>Converse All Star</p>
				<a href="/todosProductos" class="button">Ver más</a>
			</div>
		</div>
	</main>
	<style>
		.container {
			display: flex;
			flex-wrap: wrap;
			justify-content: center;
			align-items: center;
			margin: 50px;
		}
		
		.product {
			display: flex;
			flex-direction: column;
			align-items: center;
			max-width: 300px;
			margin: 20px;
			box-shadow: 0px 0px 10px #999;
			padding: 20px;
			text-align: center;
		}
		
		.product img {
			max-width: 100%;
			margin-bottom: 20px;
		}
		
		.product h3 {
			font-size: 24px;
			font-weight: bold;
			margin: 0;
			margin-bottom: 10px;
		}
		
		.product p {
			margin: 0;
			margin-bottom: 20px;
		}
		
		.product .button {
			display: inline-block;
			background-color: #007bff;
			color: #fff;
			padding: 10px 20px;
			border-radius: 5px;
			text-decoration: none;
			transition: background-color 0.3s ease-in-out;
		}
		
		.product .button:hover {
			background-color: #0062cc;
		}
		
		img{
			width: 240px;
			height: 240px;
		}
	</style>


		
		
		
		
		

	</main>
	
	<footer style="background-color: #f2f2f2; border: 1px solid black">
  <table style="width: 100%; text-align: center;">
    <tr>
      <td>
        <h3>Productos</h3>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
      </td>
      <td>
        <h3>Servicios</h3>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
      </td>
      <td>
        <h3>Conócenos</h3>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
      </td>
      <td>
        <h3>Sobre nosotros</h3>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
        <p>Datos típicos de un footer</p>
      </td>
    </tr>
  </table>
</footer>
	
	
	</footer>
</body>
</html>
			

