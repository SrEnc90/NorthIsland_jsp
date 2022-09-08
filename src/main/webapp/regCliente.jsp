<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="/WEB-INF/libreria.tld" prefix="ct"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Clientes</title>
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

	<div id="contenedor">


		<section>
			<div style="background-color: white; margin-left: 25%; width: 50%;">

				<h1
					style="margin-right: 200px; margin-bottom: 50px; font-family: Impact; font-size: 50px; color: #1F89E6; font-style: normal;">REGISTRO
					DE CLIENTES</h1>
				<form action="SCli" method="post">
					<div style="margin: 10px; width: 200px; top: 0px; right: 0px;"
						class="form-group">
						<label for="exampleInputFecha">Nro. Documento : </label> <input
							type="text" class="form-control" id="documento"
							placeholder="(DNI./PTE.)" name="txtDocumento"
							pattern="[A-Za-Z0-9]{8,10}" maxlength="10">
					</div>

					<div
						style="margin: 10px; width: 250px; top: 0px; right: 0px; float: left"
						class="form-group">
						<label for="exampleInputFecha">Nombre(s) .</label> <input
							type="text" class="form-control" id="nombre"
							placeholder="Ingrese su Nombre" name="txtNombre" maxlength="30">
					</div>

					<div
						style="margin: 10px; width: 250px; top: 0px; right: 0px; float: left"
						class="form-group">
						<label for="exampleInputFecha">Apellidos :</label> <input
							type="text" class="form-control" id="apellidos"
							placeholder="Ingrese su apellido" name="txtApellido"
							maxlength="30">
					</div>

					<div
						style="margin: 10px; width: 320px; top: 0px; right: 0px; float: left"
						class="form-group">
						<label for="exampleInputFecha">Dirección :</label> <input
							type="text" class="form-control" id="fecha"
							placeholder="Ingrese su direccion" name="txtDireccion"
							maxlength="100">
					</div>
					<div
						style="margin: 10px; width: 200px; top: 0px; right: 0px; float: left"
						class="form-group">
						<div class="col-auto my-1">
							<label for="Distrito">Distrito :</label> <select
								class="form-control" name="cboDistrito">
								<ct:llenaDistritos />

							</select>
						</div>
					</div>

					<div
						style="margin: 10px; width: 520px; top: 0px; right: 0px; float: left"
						class="form-group">
						<label for="exampleInputFecha">Correo personal :</label> <input
							type="email" class="form-control" id="fecha"
							placeholder="Ingrese su Correo" name="txtCorreo" maxlength="50">
					</div>

					<div
						style="padding-bottom: 38px; margin: 10px; width: 520px; top: 0px; right: 0px; float: left"
						class="form-group">
						<label for="contraseña">Contraseña :</label> <input
							type="password" class="form-control" id="clave"
							placeholder="Ingrese su contraseña" name="txtClave"
							maxlength="15">
					</div>


					<br>
					<p>${mensaje}</p>

					<div>
							<button style="margin:10px 10px 50px 170px;width:200px;float:left" type="submit" class="btn btn-primary" name="btnes" value="rr">Registrar</button>
						
						 <br>
   						 <p style="margin-left:70px;margin-top:530px">Si ya se encuentra registrado, clic <a href="Login.jsp">aquí</a> para Iniciar Sesión</p>
    					 <br>
						
					</div>

				</form>

			</div>
		</section>




	</div>

</body>

</html>