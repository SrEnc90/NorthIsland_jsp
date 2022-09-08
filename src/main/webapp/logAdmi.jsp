<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Administrador</title>
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

<header>
	<div id="baner">
				<img src="banner/banner1.jpg" alt="" /> 
				<img src="banner/banner2.jpg" alt="" /> 
				<img src="banner/banner3.jpg" alt="" />
				<img src="banner/banner4.jpg" alt="" />
	</div>
	</header>

<section style="background-color:white;">
<a style="color: white; text-decoration:none;" href="LoginCliente.jsp">c</a>
        <div  style="background-color:white;margin-left: 25%; width: 50%;">
        <br>
        <br>
			<h1 style="font-family:Impact; font-size: 50px; color:#1F89E6; font-style: normal;" >LOGIN ADMINISTRADOR</h1>
	    
		<form action="SEmp">
			<div style="margin-left:120px;width:400px; top: 0px;
right:0px; " class="form-group">
			
				<label for="Email">Usuario :</label> <input
					type="text" class="form-control" id="exampleInputEmail1" name="txtCorreo"
					placeholder="Ingrese su nickname">
			</div>
			<div style="margin-left:120px;width:400px; top: 0px;
right:0px; " class="form-group">
				<label for="Password">Contraseña :</label> <input
					type="password" class="form-control" id="password" name="txtClave"
					placeholder="Password">
			</div>
            <br>
            <p>${mensaje}
	        </p>
	        <br>
			<button style="margin:0px 0px 50px 280px;"  type="submit" class="btn btn-primary" name="btnes" value="v">Ingresar</button>

	<br>

	</form>
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