package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.AdministradorDTO;
import interfaces.AdministradorDAO;

/**
 * Servlet implementation class ServletAdministrador
 */
@WebServlet(name = "SEmp", urlPatterns = { "/SEmp" })
public class ServletAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entró al servlet de administradores.");
		String opc = request.getParameter("btnes");
		System.out.println("opcion : " + opc);
		switch (opc) {
		case "r":
			registro(request, response);
			break;
		case "x":
			cerrar(request, response);
			break;
		case "a":
			actualizar(request, response);
			break;
		case "e":
			eliminar(request, response);
			break;
		case "li":
			listado(request, response);
			break;
		case "bl":
			listalike(request, response);
			break;
		case "b":
			buscar(request, response);
			break;
		case "v":
			validacion(request, response);
			break;
		default:
			PrintWriter out = response.getWriter();
			out.println("<h1>Error al ingresar</h1>");
		}

	}

	private void validacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuario, clave;
		String mensaje = "", url = "";
		String datomasteremp = null;
		// entrada
		/* LP1 nomVar=txtXXX.getText(); */
		/* LP2 nomVar= request.getParameter("txtXXX"); */

		usuario = request.getParameter("txtCorreo");
		clave = request.getParameter("txtClave");

		// proceso
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		AdministradorDAO dao = fabrica.getAdministradorDAO();

		AdministradorDTO e = dao.validar(usuario, clave);

		// muestra el ID de la sesion
		System.out.println("ID de la sesion: " + request.getSession().getId());
		SimpleDateFormat sdf = new SimpleDateFormat();
		System.out.println("Creado el: " + sdf.format(request.getSession().getCreationTime()));

		// login validando sencillo
		if (e != null) {

			mensaje = "Bienvenido " + e.getNom_admi();
			// mensaje ="<script>alert('Bienvenido '+ u.getNombre()) </script>";
			url = "/Home.jsp";
			datomasteremp = "1";

		} else {
			mensaje = "<script>alert('Usuario o clave incorrecta')</script>";
			url = "/logAdmi.jsp";
		}

		// salidas
		/*
		 * crea un mensaje de salida PrintWriter out = response.getWriter();
		 * out.println("<h1>Hola Mundo</h1>");
		 */

		// para mandar una cadena de datos
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("datosemp", datomasteremp);
		request.getRequestDispatcher(url).forward(request, response);

	}
	
	private void cerrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cerrar sesión");
		request.getSession().invalidate();
		request.getRequestDispatcher("/logAdmi.jsp").forward(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet buscar empleado");
		// variables
		String codigo;
		// entradas
		// en codigo javacod=<%=x.getIdprod() %>
		codigo = request.getParameter("cod");
		// procesos
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		AdministradorDAO dao = fabrica.getAdministradorDAO();

		AdministradorDTO p = dao.buscarAdministrador(codigo);
		// salidas
		System.out.println(p);
		request.setAttribute("Data", p);
		request.getRequestDispatcher("/actualizarAdmi.jsp").forward(request, response);

	}

	private void listalike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entro al servlet listado empleados");
		String filtro;
		filtro = request.getParameter("txtCaja");
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		AdministradorDAO dao = fabrica.getAdministradorDAO();
		ArrayList<AdministradorDTO> lista = dao.listadoAdministradores(filtro);
		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/listaAdministrador.jsp").forward(request, response);

	}

	private void listado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("entro al servlet listado empleados");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		AdministradorDAO dao = fabrica.getAdministradorDAO();
		ArrayList<AdministradorDTO> lista = dao.listaNormalAdministradores();
		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/listaAdministrador.jsp").forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = "", mensaje = "";
		codigo = request.getParameter("txtCodigo");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		AdministradorDAO dao = fabrica.getAdministradorDAO();
		int ok = dao.eliminarAdministrador(codigo);
		if (ok == 0) {
			mensaje = "Cliente " + codigo + " no encontrado";
		} else {
			mensaje = "Cliente " + codigo + " eliminado con éxito";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/actualizarAdmi.jsp").forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ingreso al servlet actualizar empleado");
		String codigo, nombre, ape, nroDoc, direccion;
		int distrito, cargo;
		double sueldo;
		String fecNac, clave, correo, usuario, mensaje;

		codigo = request.getParameter("txtCodigo");
		nroDoc = request.getParameter("txtDocumento");
		nombre = request.getParameter("txtNombre");
		ape = request.getParameter("txtApe");
		distrito = Integer.parseInt(request.getParameter("cboDistrito"));
		fecNac = request.getParameter("txtFecNac");
		correo = request.getParameter("txtCorreo");
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtClave");
		cargo = Integer.parseInt(request.getParameter("cboCargo"));
		sueldo = Double.parseDouble(request.getParameter("txtSueldo"));

		if (distrito == -1) {
			mensaje = "Seleccione un distrito";
		} else {
			AdministradorDTO cli = new AdministradorDTO();
			cli.setID_admi(codigo);
			cli.setNom_admi(nombre);
			cli.setApe_admi(ape);
			cli.setDNI_admi(nroDoc);
			cli.setFechNac_admi(fecNac);
			cli.setCod_dist(distrito);
			cli.setEmail_admi(correo);
			cli.setUsuario_admi(usuario);
			cli.setClave_admi(clave);
			cli.setID_cargo(cargo);
			cli.setSueldo(sueldo);

			System.out.println(cli);
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			AdministradorDAO dao = fabrica.getAdministradorDAO();
			int ok = dao.actualizarAdministrador(cli);
			if (ok == 0) {
				mensaje = "No se pudo actualizar asegurese que no haya datos incompletos";
			} else {
				mensaje = "Empleado " + correo + " actualizado con éxito";
			}
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/actualizarAdmi.jsp").forward(request, response);

	}

	private void registro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ingreso al servlet registrar empleado");
		String nombre, ape, nroDoc, direccion;
		int distrito, cargo;
		double sueldo;
		String fecNac, clave, correo, usuario, mensaje;

		nroDoc = request.getParameter("txtDocumento");
		nombre = request.getParameter("txtNombre");
		ape = request.getParameter("txtApe");
		distrito = Integer.parseInt(request.getParameter("cboDistrito"));
		fecNac = request.getParameter("txtFecNac");
		correo = request.getParameter("txtCorreo");
		usuario = request.getParameter("txtUsuario");
		clave = request.getParameter("txtClave");
		cargo = Integer.parseInt(request.getParameter("cboCargo"));
		// fecCont= request.getParameter("txtFecCont");
		sueldo = Double.parseDouble(request.getParameter("txtSueldo"));

		if (distrito == -1) {
			mensaje = "Seleccione un distrito";
		} else {
			AdministradorDTO cli = new AdministradorDTO();
			cli.setNom_admi(nombre);
			cli.setApe_admi(ape);
			cli.setDNI_admi(nroDoc);
			cli.setFechNac_admi(fecNac);
			cli.setCod_dist(distrito);
			cli.setEmail_admi(correo);
			cli.setUsuario_admi(usuario);
			cli.setClave_admi(clave);
			cli.setID_cargo(cargo);
			cli.setSueldo(sueldo);

			System.out.println(cli);
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			AdministradorDAO dao = fabrica.getAdministradorDAO();
			int ok = dao.registrarAdministrador(cli);
			if (ok == 0) {
				mensaje = "No se pudo registrar, asegurese que no haya datos incompletos";
			} else {
				mensaje = "Administrador " + correo + " Registrado exitosamente";
			}
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/regAdmi.jsp").forward(request, response);

	}

}
