package etiquetas;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.DAOFactory;
import entities.DistritoDTO;
import interfaces.AdministradorDAO;

@SuppressWarnings("serial")
public class LlenaDistritos extends TagSupport {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<option selected value=\"-1\">Seleccione...</option>");
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			AdministradorDAO dao = fabrica.getAdministradorDAO();
			ArrayList<DistritoDTO> listado = dao.listaDistritos();

			for (DistritoDTO c : listado) {
				out.println("<option value=\"" + c.getCodigoDist() + "\">" + c.getNombreDist() + "</option>");
			}
		} catch (Exception e) {
			System.out.println("Error al realizar llenadistritos : " + e.getMessage());
		}

		return SKIP_BODY;

	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
