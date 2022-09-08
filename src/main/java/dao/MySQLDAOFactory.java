package dao;

import interfaces.AdministradorDAO;
import interfaces.BoletaDAO;
import interfaces.ClienteDAO;
import interfaces.ProductoDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new MySQLProductoDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		// TODO Auto-generated method stub
		return new MySQLClienteDAO();
	}

	@Override
	public AdministradorDAO getAdministradorDAO() {
		// TODO Auto-generated method stub
		return new MySQLAdministradorDAO();
	}

	@Override
	public BoletaDAO getBoletaDAO() {
		// TODO Auto-generated method stub
		return new MySQLBoletaDAO();
	}

}
