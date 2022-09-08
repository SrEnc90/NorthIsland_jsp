package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQLConexion {

	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/NORTHISLAND?serverTimezone=UTC";
			String usr = "root";
			String psw = "";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD");
		} catch (Exception e) {
			System.out.println("Error >>  "+e.getMessage());
		}
		return con;
	}

	public static void closeConexion(Connection con) {

		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Problemas al cerrar la conexion");
		}
	}

}
/*
public class MySQLConexion {
	public static Connection getConexion(){
		Connection cn=null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost/MUNDOTRONIC_PERU?serverTimezone=UTC";
				cn=DriverManager.getConnection(url,"root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;	
	}
}*/

