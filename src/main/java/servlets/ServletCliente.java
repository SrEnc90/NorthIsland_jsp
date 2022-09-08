package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.ClienteDTO;
import interfaces.ClienteDAO;


/**
 * Servlet implementation class ServletCliente
 */
@WebServlet(name = "SCli", urlPatterns = { "/SCli" })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entró al servlet de clientes.");
		String opc = request.getParameter("btnes");
		System.out.println("opcion : " + opc);
		switch (opc) {
		case "r":
			registro(request, response);
			break;
		case "a":
			actualizar(request, response);
			break;
		case "e":
			eliminar(request, response);
			break;
		case "l":
			listado(request, response);
			break;
		case "bl":
			listalike(request, response);
			break;
		case "b":
			buscar(request, response);
			break;
		case "rr":
			regcli(request, response);
			break;
		case "v":
			validacion(request, response);
			break;
		case "x":
			cerrar(request, response);
			break;
		default:
			PrintWriter out = response.getWriter();
			out.println("<h1>Error al ingresar</h1>");

		}

	}

	private void regcli(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nroDoc, nombre, apellido, direccion, correo, contraseña;
		int distrito;
		String mensaje = "";
		nroDoc = request.getParameter("txtDocumento");
		nombre = request.getParameter("txtNombre");
		apellido = request.getParameter("txtApellido");
		distrito = Integer.parseInt(request.getParameter("cboDistrito"));
		direccion = request.getParameter("txtDireccion");
		correo = request.getParameter("txtCorreo");
		contraseña = request.getParameter("txtClave");

		if (distrito == -1) {
			mensaje = "Seleccione un distrito";
		} else {
			ClienteDTO cli = new ClienteDTO();
			cli.setNroDoc(nroDoc);
			cli.setNombre(nombre);
			cli.setApellido(apellido);
			cli.setDireccion(direccion);
			cli.setCoddist(distrito);
			cli.setCorreo(correo);
			cli.setClave(contraseña);

			System.out.println(cli);
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ClienteDAO dao = fabrica.getClienteDAO();
			int ok = dao.registrarCliente(cli);
			if (ok == 0) {
				mensaje = "No se pudo registrar correo en uso";
			} else {
				mensaje = "Cliente " + correo + " registrado con éxito";
			}
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/Login.jsp").forward(request, response);

	}

	private void cerrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cerrar sesión");
		request.getSession().invalidate();
		request.getRequestDispatcher("/Home.jsp").forward(request, response);

	}

	private void listalike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entro al servlet listado clientes like");

		String letras = "";
		// entradas
		letras = request.getParameter("txtCaja");
		// procesos

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClienteDAO dao = fabrica.getClienteDAO();
		ArrayList<ClienteDTO> lista = dao.listadolikeClientes(letras);
		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/listaclientes.jsp").forward(request, response);

	}

	private void validacion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String usuario, clave;
		String mensaje="",url="";
		String datomastercli="0";
		//entrada
		/*LP1  nomVar=txtXXX.getText();*/
		/*LP2  nomVar= request.getParameter("txtXXX");*/
		
		usuario= request.getParameter("txtCorreo");
		clave  = request.getParameter("txtClave");
		
		//proceso
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	    ClienteDAO  dao = fabrica.getClienteDAO();
		
		
		ClienteDTO c= dao.validar(usuario, clave);
		
		//muestra el ID de la sesion
		System.out.println("ID de la sesion: "+ request.getSession().getId());
		SimpleDateFormat sdf= new SimpleDateFormat();
		System.out.println("Creado el: "+ sdf.format(request.getSession().getCreationTime()));

		// login validando sencillo
		if(c !=null) {
		
			mensaje="Bienvenido "+ c.getNombre();
			//mensaje ="<script>alert('Bienvenido '+ u.getNombre()) </script>";
			url="/Home.jsp";
			datomastercli="1";
		}
		else {
			mensaje ="<script>alert('Usuario o clave incorrecta')</script>";
			url="/logAdmi.jsp";
		}
		
		//salidas
		/*crea un mensaje de salida 
		PrintWriter out = response.getWriter();
		out.println("<h1>Hola Mundo</h1>");
		*/
		
		//para mandar una cadena de datos
		request.setAttribute("mensaje", mensaje);
		request.getSession().setAttribute("datoscli", datomastercli);
			request.getRequestDispatcher(url).forward(request, response);

		
	
		
		
	}

	private void listado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entro al servlet listado clientes");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClienteDAO dao = fabrica.getClienteDAO();
		ArrayList<ClienteDTO> lista = dao.listadoClientes();
		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/listaclientes.jsp").forward(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet buscar cliente");
		// variables
		String codigo;
		// entradas
		// en codigo javacod=<%=x.getIdprod() %>
		codigo = request.getParameter("cod");
		// procesos
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClienteDAO dao = fabrica.getClienteDAO();

		ClienteDTO p = dao.buscarCliente(codigo);
		// salidas
		System.out.println(p);
		request.setAttribute("Data", p);
		request.getRequestDispatcher("/actualizarcliente.jsp").forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = "", mensaje = "";
		codigo = request.getParameter("txtCodigo");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		ClienteDAO dao = fabrica.getClienteDAO();
		int ok = dao.eliminarCliente(codigo);
		if (ok == 0) {
			mensaje = "Cliente " + codigo + " no encontrado";
		} else {
			mensaje = "Cliente " + codigo + " eliminado con éxito";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/listaclientes.jsp").forward(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo, nroDoc, nombre, apellido, direccion, fijo, celular, correo, clave;
		int distrito;
		List<ClienteDTO>lista= null;
		String retorno = "/listaclientes.jsp";
		String mensaje = "";
		codigo = request.getParameter("txtCodigo");
		nroDoc = request.getParameter("txtDocumento");
		nombre = request.getParameter("txtNombre");
		apellido = request.getParameter("txtApellido");
		distrito = Integer.parseInt(request.getParameter("cboDistrito"));
		direccion = request.getParameter("txtDireccion");
		correo = request.getParameter("txtCorreo");
		clave = request.getParameter("txtClave");

		/*if (distrito == -1) {
			mensaje = "Seleccione un distrito";
		} else {*/
			ClienteDTO cli = new ClienteDTO();
			cli.setCodigo(codigo);
			cli.setNroDoc(nroDoc);
			cli.setNombre(nombre);
			cli.setApellido(apellido);
			cli.setDireccion(direccion);
			cli.setCoddist(distrito);
			cli.setCorreo(correo);
			cli.setClave(clave);

			System.out.println(cli);
			System.out.println(cli.getCoddist());
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ClienteDAO dao = fabrica.getClienteDAO();
			int ok = dao.actualizarCliente(cli);
			if (ok == 0) {
				mensaje = "No se pudo actualizar asegurese que no haya datos incompletos";
				retorno = "/actualizarcliente.jsp";
				lista = new ArrayList<ClienteDTO>();
			} else {
				mensaje = "Cliente " + correo + " actualizado con éxito";
				lista=dao.listadoClientes();
		
		}
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("milista", lista);
		request.setAttribute("Data", cli);
		request.getRequestDispatcher(retorno).forward(request, response);
		
		

	}

	private void registro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo, nroDoc, nombre, apellido, direccion, telefono, celular, correo, contraseña;
		int distrito;
		String mensaje = "";
		codigo = request.getParameter("txtCodigo");
		nroDoc = request.getParameter("txtDocumento");
		nombre = request.getParameter("txtNombre");
		apellido = request.getParameter("txtApellido");
		distrito = Integer.parseInt(request.getParameter("cboDistrito"));
		direccion = request.getParameter("txtDireccion");
		correo = request.getParameter("txtCorreo");
		contraseña = request.getParameter("txtClave");

		if (distrito == -1) {
			mensaje = "Seleccione un distrito";
		} else {
			ClienteDTO cli = new ClienteDTO();
			cli.setCodigo(codigo);
			cli.setNroDoc(nroDoc);
			cli.setNombre(nombre);
			cli.setApellido(apellido);
			cli.setDireccion(direccion);
			cli.setCoddist(distrito);
			cli.setCorreo(correo);
			cli.setClave(contraseña);

			System.out.println(cli);
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ClienteDAO dao = fabrica.getClienteDAO();
			int ok = dao.registrarCliente(cli);
			if (ok == 0) {
				mensaje = "No se pudo registrar correo en uso";
			} else {
				mensaje = "Cliente " + correo + " registrado con éxito";
			}
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/mantClientes.jsp").forward(request, response);

	}

}
