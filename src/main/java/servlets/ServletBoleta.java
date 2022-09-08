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
import entities.BoletaDTO;
import entities.ProductoDTO;
import entities.RepBoletaDTO;
import interfaces.BoletaDAO;

/**
 * Servlet implementation class ServletBoleta
 */
@WebServlet(name = "SBol", urlPatterns = { "/SBol" })
public class ServletBoleta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Entró al servlet de boletas.");
		String opc = request.getParameter("btnes");
		System.out.println("opcion : " + opc);
		switch (opc) {

		case "rf":
			reportfecha(request, response);
			break;
		case "re":
			reportestado(request, response);
			break;
		default:
			PrintWriter out = response.getWriter();
			out.println("<h1>Error al ingresar</h1>");
		}

	}

	private void reportestado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("entro al servlet reporte boleta estado");
		int estado = -1;
		String mensaje = "";
		estado = Integer.parseInt(request.getParameter("cboestado"));

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletaDAO dao = fabrica.getBoletaDAO();
		if (estado == -1) {
			mensaje = "Seleccione un estado para su búsqueda";
		} else {
			ArrayList<BoletaDTO> lista = dao.reporteestadoboleta(estado);
			request.setAttribute("mensaje", mensaje);
			request.setAttribute("milista", lista);
		}
		request.getRequestDispatcher("/ReporteEstadoBoleta.jsp").forward(request, response);
	}

	private void reportfecha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fecha1 = "", fecha2 = "", mensaje = "";
		fecha1 = request.getParameter("fechainicial");
		fecha2 = request.getParameter("fechafinal");

		if (fecha1.equals("") || fecha2.equals("")) {
			mensaje = "complete los campos solicitados";
		} else if (fecha1.compareTo(fecha2) > 0) {
			mensaje = "La fecha inicial no puede ser mayor a la fecha final";
		} else {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			BoletaDAO dao = fabrica.getBoletaDAO();
			ArrayList<RepBoletaDTO> lista = dao.reportefechaboleta(fecha1, fecha2);

			request.setAttribute("milista", lista);
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/ReporteFechaBoleta.jsp").forward(request, response);

	}

}
