package interfaces;

import java.util.ArrayList;

import entities.BoletaDTO;
import entities.EstadoBolDTO;
import entities.RepBoletaDTO;

public interface BoletaDAO {

	public ArrayList<RepBoletaDTO> reportefechaboleta(String x, String y);

	public ArrayList<BoletaDTO> reporteestadoboleta(int est);

	public ArrayList<EstadoBolDTO> listaestadosBol();

}
