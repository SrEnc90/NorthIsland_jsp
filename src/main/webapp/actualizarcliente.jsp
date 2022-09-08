
<!DOCTYPE html>
<%@page import="entities.ClienteDTO"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct" %>	
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mantenimiento de Clientes</title>
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


<div id="contenedor">

<header>
	<div id="baner">
	<img src="banner/banner1.jpg" alt=""/>
	<img src="banner/banner2.jpg" alt=""/>
	<img src="banner/banner3.jpg" alt=""/>
	<img src="banner/banner4.jpg" alt=""/>
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
				<li class="nav-item active"><a class="nav-link" href="#">Conocenos</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Reporte</a></li>
				<li class="nav-item dropdown"><a style="color: white;"
						class="nav-link dropdown-toggle" href="Home.jsp"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Mantenimientos </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="SCli?btnes=l">Clientes</a> <a
								class="dropdown-item" href="mantEmpleados.jsp">Empleados</a> <a
								class="dropdown-item" href="mantProductos.jsp">Productos</a>
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

		
<section>
<div  style="background-color:white;margin-left: 25%; width: 50%;">

		<h1 style="margin-right:200px;margin-bottom:50px;font-family:Impact; font-size: 50px; color:#1F89E6; font-style: normal;" >Mantenimiento de Clientes</h1>
		<form action="SCli" method="post">
	<div style="margin:10px;width:250px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="exampleInputFecha">Código :</label> <input
					type="text" class="form-control" id="codigo"
					placeholder="Ingrese el codigo" name="txtCodigo" pattern="[A-Za-z0-9]{7}" maxlength="7" readonly="readonly"
					 value="${Data.codigo }">
	</div>
	
	<div style="margin:10px;width:250px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="exampleInputFecha">Nro. Documento : </label> <input
					type="text" class="form-control" id="documento"
					placeholder="(DNI./PTE.)" name="txtDocumento" pattern="[A-Za-Z0-9]{8,10}" maxlength="10"
					value="${Data.nroDoc }">
	</div>

	<div style="margin:10px;width:250px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="exampleInputFecha">Nombre(s) .</label> <input
					type="text" class="form-control" id="nombre"
					placeholder="Ingrese su Nombre" name="txtNombre" maxlength="30" 
					value="${Data.nombre }">
	</div>
	
		<div style="margin:10px;width:250px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="exampleInputFecha">Apellidos :</label> <input
					type="text" class="form-control" id="apellidos"
					placeholder="Ingrese su apellido" name="txtApellido"  maxlength="30"
					value="${Data.apellido }">
	</div>
	
		<div style="margin:10px;width:310px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="exampleInputFecha">Dirección :</label> <input
					type="text" class="form-control" id="fecha"
					placeholder="Ingrese su direccion" name="txtDireccion"  maxlength="100"
					value="${Data.direccion }">
	</div>
	  <div style="margin:10px;width:250px; top: 0px;
right:0px;float:left" class="form-row align-items-center" style="width:45%">
				<div class="col-auto my-1">
					<label for="Distrito">Distrito :</label> <select
						class="form-control" name="cboDistrito">
                    <ct:llenaDistritos />	
					</select>
				</div>
				</div>
	
		
	
		<div style="margin:10px;width:520px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="exampleInputFecha">Correo personal :</label> <input
					type="email" class="form-control" id="fecha"
					placeholder="Ingrese su Correo" name="txtCorreo"  maxlength="50"
					value="${Data.correo }">
	</div>
	
		<div style="padding-bottom:36px;margin:10px;width:520px; top: 0px;
right:0px;float:left" class="form-group">
	<label for="contraseña">Contraseña :</label> <input
					type="password" class="form-control" id="clave"
					placeholder="Ingrese su contraseña" name="txtClave"   maxlength="15"
					value="${Data.clave }">
	</div>
	

	  <br>
	<div style="margin:20px;" class="form-group">
	<label style="margin-bottom:20px;"> ${mensaje }
	</label>
    </div>
	<button style="margin:10px 10px 30px 30px;width:200px;float:left" type="submit" class="btn btn-warning" name="btnes" value="a">Actualizar</button>
	<button style="margin:10px 10px 30px 30px;width:200px;float:left" type="submit" class="btn btn-danger" name="btnes" value="e">Eliminar</button>
	<button style="margin:10px 10px 30px 30px;width:200px;float:left" type="submit" class="btn btn-info" name="btnes" value="l">Listado</button>
	
    </form>
    <br>
    <br>
    </div>
    </section>	
    
	<footer>
			<p>SIEMPRE A LA DISPOSICION DE NUESTRO PUBLICO</p>
			<p></p>

		</footer>


</div>

</body>
</html>