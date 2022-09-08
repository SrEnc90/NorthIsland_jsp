package interfaces;

import java.util.ArrayList;

import entities.ClienteDTO;
import entities.DistritoDTO;

public interface ClienteDAO {

	//REGISTRAR CLIENTE
	public int registrarCliente(ClienteDTO c);

	//ACTUALIZAR CLIENTE
	public int actualizarCliente(ClienteDTO c);

	//ELIMINAR CLIENTE
	public int eliminarCliente(String c);

	//LISTADO 
	public ArrayList<ClienteDTO> listadolikeClientes(String c);

	//BUSCAR CLIENTE POR CAMPO
	public ClienteDTO buscarCliente(String c);

	//LISTADO GENERAL
	public ArrayList<ClienteDTO> listadoClientes();

	//LOGIN CLIENTE
	public ClienteDTO validar(String x, String y);

	//LISTADO DISTRITOS
	public ArrayList<DistritoDTO> listadistritos();

}
