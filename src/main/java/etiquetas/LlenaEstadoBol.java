package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.DAOFactory;
import entities.EstadoBolDTO;
import interfaces.BoletaDAO;

@SuppressWarnings("serial")
public class LlenaEstadoBol extends TagSupport {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<option selected value=\"-1\">Seleccione...</option>");
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			BoletaDAO dao = fabrica.getBoletaDAO();
			ArrayList<EstadoBolDTO> listado = dao.listaestadosBol();

			for (EstadoBolDTO c : listado) {
				out.println("<option value=\"" + c.getCodigo() + "\">" + c.getDescripcion() + "</option>");
			}
		} catch (IOException e) {
			System.out.println("Error al realizar llenar categorias : " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
