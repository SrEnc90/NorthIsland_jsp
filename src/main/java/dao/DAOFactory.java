package dao;

import interfaces.AdministradorDAO;
import interfaces.BoletaDAO;
import interfaces.ClienteDAO;
import interfaces.ProductoDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int SQL = 2;
	public static final int ACCESS = 3;
	public static final int SQLite = 5;
	public static final int ORACLE = 6;

	public abstract ProductoDAO getProductoDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract AdministradorDAO getAdministradorDAO();
	public abstract BoletaDAO getBoletaDAO();

	// METODO PARA IMPLEMENTAR LAS INTERFACES SEGUN LA BASE DE DATOS
	public static DAOFactory getDAOFactory(int qFactory) {
		switch (qFactory) {
		case MYSQL:
			return new MySQLDAOFactory();
		// CL<SE PARA IMPLEMENTAR LOS PROCESOS COM MySql

		case SQL:
			// return new SQLDAOFactory();

		case ACCESS:
			// return new ACCESSDAOFactory();

		case SQLite:
			// return new SQLITEDAOFactory();

		case ORACLE:
			// return new ORACLEDAOFactory();

		default:
			return null;
		}
	}

}
