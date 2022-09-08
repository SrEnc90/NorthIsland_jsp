<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Con�cenos</title>
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
<script src="js/HOME.js"></script>


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
				<a class="nav-link" href="SPro?btnes=cata">Cat�logo
						<span class="sr-only"></span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="Conocenos.jsp">Con�cenos</a><%
		
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
		
			<section>
				<br> <br>
				<h1 style="color:blue;margin-left:10%;margin-right: 10%">�Qui�nes Somos?</h1>
				<br>
				<p style="font-size:15pt;margin-left:10%;margin-right: 10%;color: olive;">Es una empresa Peruana, dedicada a la comercializaci�n de prendas de alta Calidad,
				 de las mejores Marcas, de prestigio mundial, como Polos, Jeans, Enterizos, 
				 Chompas y Articulos para clientes finales y distribuidores; 
				 marcando tendencia en Moda.
				 El mayor valor agregado que transmite a sus clientes es la seguridad en su compra, el cliente en Northisland compra Calidad, Seguridad y Tranquilidad 
				 y sabe que puede darle un uso adecuado a su ropa, Los cuales cuentan con una s�lida calidad </p>
				<br>
				<h1 style="color:blue;margin-left:10%;margin-right: 10%">�Cu�l es nuestra misi�n?</h1>
				<br>
				<p style="font-size:15pt;margin-left:10%;margin-right: 10%; color: olive;"> 
				
				Nuestra misi�n es hacer crecer nuestra empresa de manera rentable al comprender las necesidades de nuestros clientes, 
				centr�ndonos en la excelencia operativa y fomentando la innovaci�n de las prendas de vestir.
				
				en el Per�, otorgando el mayor grado de satisfacci�n a nuestros clientes a trav�s de una asesor�a especializada y cercana,
				ofreciendo la m�s amplia variedad de productos y los precios m�s accesibles.
				 
	            Este �xito se debe en gran medida a la lealtad de nuestros clientes, quienes por medio de su confianza han hecho posible el cumplimiento de las metas de crecimiento en forma sostenida.</p>
				<br>
				<h1 style="color:blue;margin-left:10%;margin-right: 10%">�C�mo comunicarnos?</h1>
				<br>
				<p style="font-size:15pt;margin-left:10%;margin-right: 10%; color: olive;">Puedes comunicarnos a trav�s de facebook, Buscanos como Northisland - PERU  </p>
				<br> <br>
				
				<br>
				<br>
				<p style="font-size:8pt;margin-left:45%;margin-right: 10%;color:gray">El que persevera alcanza el �xito...</p>
				<br>
			</section>
		<footer>
			<p>SIEMPRE A LA DISPOSICION DE NUESTRO PUBLICO</p>
			<p></p>
			
		</footer>
	</div>
</body>
</html>