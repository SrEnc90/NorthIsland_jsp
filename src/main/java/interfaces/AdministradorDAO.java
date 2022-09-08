package interfaces;

import java.util.ArrayList;

import entities.AdministradorDTO;
import entities.CargoDTO;
import entities.DistritoDTO;

public interface AdministradorDAO {

	//REGISTRAR ADMINISTRADOR NUEVO
	public int registrarAdministrador(AdministradorDTO a);
	
	//ACTUALIZAR DATOS DEL ADMINISTRADOR
	public int actualizarAdministrador(AdministradorDTO a);
	
	//ELIMINAR ADMINISTRADOR
	public int eliminarAdministrador(String a);
	
	//BUSCAR ADMINISTRADOR
	public AdministradorDTO buscarAdministrador(String a);
	
	//LOGIN 
	public AdministradorDTO validar(String x, String y);
	
	//LISTADO DE DISTRITOS
	public ArrayList<DistritoDTO>listaDistritos();
	
	//LISTADO DE CARGOS
	public ArrayList<CargoDTO>listaCargos();
	
	//LISTADO DE ADMINISTRADORES POR UN CAMPO
	public ArrayList<AdministradorDTO>listadoAdministradores(String a);
	
	//LISTADO SIMPLE, ABARCA TODOS LOS CAMPOS
	public ArrayList<AdministradorDTO>listaNormalAdministradores();
}
