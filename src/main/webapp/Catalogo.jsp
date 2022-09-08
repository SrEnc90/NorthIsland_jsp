
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="entities.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/libreria.tld" prefix="ct" %>	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catálogo</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<link href="css/estiloProductos.css" rel="stylesheet" type="text/css">
<link href="../font.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="js/jquery-3.2.1.js"></script>
<script src="js/jquery.cycle.all.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<script src="js/Productos.js"></script>


<body background="fondo/azul.jpg">

	<div id="contenedor">
		<header>
			<div id="baner" style="max-width: 100%; min-width: 100%">
				<img src="banner/banner1.jpg" alt="" /> 
				<img src="banner/banner2.jpg" alt="" /> 
				<img src="banner/banner3.jpg" alt="" />
				<img src="banner/banner4.jpg" alt="" />
			</div>
		</header>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="Home.jsp">NORTHISLAND</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
				<a class="nav-link" href="SPro?btnes=cata">Catálogo
						<span class="sr-only"></span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="Conocenos.jsp">Conócenos</a><%
		
		String datomaster = (String) request.getSession().getAttribute("datosemp");
		if (datomaster != null ) { %> 
		
		<li class="nav-item dropdown"><a style="color: white;"
						class="nav-link dropdown-toggle" href="Home.jsp"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Reportes</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="ReporteFechaBoleta.jsp">Boletas emitidas por intervalo</a> <a
								class="dropdown-item" href="ReporteEstadoBoleta.jsp">Estado de Boletas</a>
						</div>
		</li>
		
		
		
		
				
			
				<li class="nav-item dropdown"><a style="color: white;"
						class="nav-link dropdown-toggle" href="Home.jsp"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Mantenimientos </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="SCli?btnes=l">Clientes</a> <a
								class="dropdown-item" href="SEmp?btnes=li">Administradores</a> <a
								class="dropdown-item" href="SPro?btnes=l">Equipos</a>
						</div>
				</li>
				
			
				<li class="nav-item dropdown"><a style="color: white;"
						class="nav-link dropdown-toggle" href="Home.jsp"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Registrar</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							 <a class="dropdown-item" href="regAdmi.jsp">Administrador</a> 
							 <a class="dropdown-item" href="regEquipo.jsp">Equipos</a>
						</div>
				</li>
				<% } else{ }%>
			
				
				
			</ul>
			
			
			
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					
					
					<% String datomaster1 =(String) request.getSession().getAttribute("datoscli");
	    			   String datomaster2 = (String)request.getSession().getAttribute("datosemp");
	   				if(datomaster!=null || datomaster1!=null){ %> 
	   				
	   				<a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
	   				
	   				Opciones </a>
	   				
	   				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="SCli?btnes=x" href="Login.jsp">Cerrar Sesion </a>
					</div>
	   				
	   						<% }
	   				else {%> 
	   				
	   				<a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false">
	   				
	   				Iniciar Sesion </a> 
	   				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="Login.jsp">Cliente</a> <a
							class="dropdown-item" href="logAdmi.jsp">Administrador</a>
						
					</div>
	   				<%  }
					 %>
					</li>
			</ul>
		</div>
	</nav>
	
	<br>
	<br>
	<section>
	
	<div class="container" style="background-color:white;">
	<br>
	<h1>Lo que necesite al mejor precio</h1>
	<br>
		
			<c:forEach items="${milista }" var="x">
	        <figure style="border: 5px groove #E6E6FA;border-radius:6px;">
				<a href="SPro?btnes=b&cod=${x.codigo }">
				<img src="imgPro/${x.codigo }.jpg" height="150px" width="150px" alt="${x.nombre }">
				</a>
				<a style="background-color:#FFF8DC;padding:10px 20px;text-decoration:none;" href="SPro?btnes=b&cod=${x.codigo }">${x.nombre }</a>
				<p style="color:darkblue;">S/. ${x.precio }0</p>
			</figure> 
			</c:forEach>
		<!--  </table>-->	
	</div>
	</section>
		<footer>
			<p>SIEMPRE A LA DISPOSICION DE NUESTRO PUBLICO</p>
			<p></p>
	
		</footer>

	</div>

</body>
</html>