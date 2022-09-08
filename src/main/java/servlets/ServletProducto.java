package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import entities.ProductoDTO;
import interfaces.ProductoDAO;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet(name = "SPro", urlPatterns = { "/SPro" })
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al servlet de productos");
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
		case "lk":
			listadoLike(request, response);
			break;
		case "b":
			buscar(request, response);
			break;
		case "cata":
			listaCatalogo(request, response);
			break;
		default:
			PrintWriter out = response.getWriter();
			out.println("<h1>Error al ingresar</h1>");
		}
	}

	private void listaCatalogo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entro al servlet lista catalogo");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		ArrayList<ProductoDTO> lista = dao.listaProductos();
		// procesos

		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/Catalogo.jsp").forward(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al servlet buscar producto");
		// variables
		String codigo = "";
		// entradas
		// en codigo javacod=<%=x.getIdprod() %>
		codigo = request.getParameter("cod");
		// procesos
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();

		ProductoDTO p = dao.buscarProducto(codigo);
		// salidas

		request.setAttribute("data", p);
		request.getRequestDispatcher("/actualizarProducto.jsp").forward(request, response);

	}

	private void listado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("entro al servlet listado productos");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		ArrayList<ProductoDTO> lista = dao.listaProductos();
		// procesos

		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/listaProducto.jsp").forward(request, response);

	}

	private void listadoLike(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("entro al servlet listado productos");

		String letras = "";

		letras = request.getParameter("txtCaja");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDAO dao = fabrica.getProductoDAO();
		ArrayList<ProductoDTO> lista = dao.listaXlike(letras);
		// procesos

		// salidas
		request.setAttribute("milista", lista);
		request.getRequestDispatcher("/listaProducto.jsp").forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = "";
		String mensaje = "";
		codigo = request.getParameter("txtCodigo");
		if (codigo.equals("")) {
			mensaje = "codigo no encontrado o no ingresado";
		} else {

			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ProductoDAO e = fabrica.getProductoDAO();
			// int ok=
			e.eliminarProducto(codigo);
			mensaje = "Producto " + codigo + " Eliminado con éxito";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/actualizarProducto.jsp").forward(request, response);

	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet actualizar producto");
		
		String codigo = "", nombre = "", descripcion = "";
		int stock = 0;
		double precio = 0.00;
		String mensaje = "";
		int categoria = -1;
		// String url;
		codigo = request.getParameter("txtCodigo");
		nombre = request.getParameter("txtNombre");
		descripcion = request.getParameter("txtDescripción");
		precio = Double.parseDouble(request.getParameter("txtPrecio"));
		stock = Integer.parseInt(request.getParameter("txtStock"));
		categoria = Integer.parseInt(request.getParameter("cboCategoria"));

		if (categoria == -1) {
			mensaje = "seleccione una categoría";
		} else {
			ProductoDTO pr = new ProductoDTO();
			pr.setCodigo(codigo);
			pr.setNombre(nombre);
			pr.setDescripcion(descripcion);
			pr.setStock(stock);
			pr.setPrecio(precio);
			pr.setCategoria(categoria);

			System.out.println(pr);

			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ProductoDAO dao = fabrica.getProductoDAO();
			int ok = dao.actualizarProducto(pr);
			if (ok == 0) {
				mensaje = "Error al actualizar producto";
			} else {
				mensaje = "Actualización del producto " + nombre + " exitoso";
			}
		}

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/actualizarProducto.jsp").forward(request, response);

	}

	private void registro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = "", nombre = "", descripcion = "";
		int stock = 0;
		double precio = 0.00;
		String mensaje = "";
		int categoria = -1;
		// String url;
		codigo = request.getParameter("txtCodigo");
		nombre = request.getParameter("txtNombre");
		descripcion = request.getParameter("txtDescripcion"); 
		precio = Double.parseDouble(request.getParameter("txtPrecio"));
		stock = Integer.parseInt(request.getParameter("txtStock"));
		categoria = Integer.parseInt(request.getParameter("cboCategoria"));

		if (categoria == -1) {
			mensaje = "seleccione una categoría";
		} else {
			ProductoDTO pr = new ProductoDTO();
			pr.setCodigo(codigo);
			pr.setNombre(nombre);
			pr.setDescripcion(descripcion);
			pr.setStock(stock);
			pr.setPrecio(precio);
			pr.setCategoria(categoria);

			System.out.println(pr);

			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ProductoDAO dao = fabrica.getProductoDAO();

			int ok = dao.registrarProducto(pr);
			if (ok == 0) {
				mensaje = "Error al registrar equipo";
			} else {
				mensaje = "Registro del producto " + nombre + " exitoso";
			}
		}

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/regEquipo.jsp").forward(request, response);

	}

}
