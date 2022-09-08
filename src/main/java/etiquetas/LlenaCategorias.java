package etiquetas;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import dao.DAOFactory;
import entities.CategoriaDTO;
import interfaces.ProductoDAO;

@SuppressWarnings("serial")
public class LlenaCategorias extends TagSupport {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		try {
			out.println("<option selected value=\"-1\">Seleccione...</option>");
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ProductoDAO dao = fabrica.getProductoDAO();
			ArrayList<CategoriaDTO> listado = dao.listaCategorias();

			for (CategoriaDTO c : listado) {
				out.println("<option value=\"" + c.getCodigo() + "\">" + c.getNombre() + "</option>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al realizar llenar categorias : " + e.getMessage());
		}
		return SKIP_BODY;
	}
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
		}	

}
