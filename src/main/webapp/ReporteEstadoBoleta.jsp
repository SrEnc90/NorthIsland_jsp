
<!DOCTYPE html>

<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="sorre"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct"%>
<html lang="esS">
<head>
<meta charset="ISO-8859-1">
<title>Reporte de Boletas</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

</head>
<link href="css/estiloHome.css" rel="stylesheet" type="text/css">
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
<script src="js/HOME.js"></script>

<body background="fondo/azul.jpg">  


	<%
	
	String datomaster = (String) request.getSession().getAttribute("datosemp");
	if (datomaster != null ) {
		String sorre = "null";
	} else {
		request.getRequestDispatcher("/logAdmi.jsp").forward(request, response);
	}
	%>

	<div id="contenedor" style="background-color: white;">
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
				<li class="nav-item active"><a class="nav-link" href="Conocenos.jsp">Conocenos</a></li>
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
				
				
				
			</ul>
			
			<ul class="navbar-nav">
									<li class="nav-item dropdown">
					
					
					<% 
	    			   String datomaster2 = (String)request.getSession().getAttribute("datosemp");
	   				if(datomaster!=null ){ %> 
	   				
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

	   				<%  }
					 %>
					</li>
			</ul>
		</div>
	</nav>
	
		<h1>Reporte de Boletas Por Estado de activación</h1>
		<form action="SBol">
			<div
				style="margin-top:30px;margin-left: 30%;margin-bottom:30px; width: 200px; top: 0px; right: 0px; float: left"
				class="form-group">
				<label for="estado">Seleccione el estado correspondiente :</label> <select
					class="form-control" name="cboestado">
					<ct:llenaEstadoBoletas />

				</select>
			</div>


			<button style="margin-top:30px;margin-left: 200px;margin-bottom:30px;width: 200px; top: 0px; right: 0px; float: left" type="submit" class="btn btn-warning" name="btnes" value="re">FILTRAR</button>
		</form>
		<br> <br>

		<div class="container" style="background-color: white;">
			<table class="table">

				<tr style="background-color:#FFD700">

					<th><strong>Nro. Boleta</strong></th>
					<th><strong>Fecha Emisión</strong></th>
					<th><strong>Id Cliente</strong></th>
					<th><strong>Subtotal</strong></th>
					<th><strong>IGV</strong></th>
					<th><strong>Total</strong></th>



				</tr>

				<sorre:forEach items="${milista }" var="x">
					<tr style="background-color:#FFFAFA" class="grilla_campo">
						<td>${x.numerobol }</td>
						<td>${x.fecha }</td>
						<td>${x.cliente }</td>
						<td>S/. ${x.subtotal }0</td>
						<td>${x.igv }0%</td>
						<td>S/. ${x.total }0</td>
					</tr>
				</sorre:forEach>
			</table>


		</div>
		<footer>
			<p>SIEMPRE A LA DISPOSICION DE NUESTRO PUBLICO</p>
			<p></p>

		</footer>

	</div>
</body>
</html>

