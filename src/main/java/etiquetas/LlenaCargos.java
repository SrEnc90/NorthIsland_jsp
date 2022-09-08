package etiquetas;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.DAOFactory;
import entities.CargoDTO;
import interfaces.AdministradorDAO;

@SuppressWarnings("serial")
public class LlenaCargos extends TagSupport {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<option selected value=\"-1\">Seleccione...</option>");
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			AdministradorDAO dao = fabrica.getAdministradorDAO();
			ArrayList<CargoDTO> listado = dao.listaCargos();

			for (CargoDTO c : listado) {
				out.println("<option value=\"" + c.getIdcargo() + "\">" + c.getDescripcion() + "</option>");
			}
		} catch (IOException e) {
			System.out.println("Error al realizar llenaCargos : " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

}
