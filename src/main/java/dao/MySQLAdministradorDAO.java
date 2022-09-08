	package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.MySQLConexion;
import entities.AdministradorDTO;
import entities.CargoDTO;
import entities.DistritoDTO;
import interfaces.AdministradorDAO;

public class MySQLAdministradorDAO implements AdministradorDAO {

	@Override
	public int registrarAdministrador(AdministradorDTO a) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into ADMINISTRADOR VALUES (genera_admi(),?,?,?,?,?,?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			/*pst.setString(1, a.getID_admi());*/
			pst.setString(1, a.getNom_admi());
			pst.setString(2, a.getApe_admi());
			pst.setString(3, a.getDNI_admi());
			pst.setString(4, a.getFechNac_admi());
			pst.setInt(5, a.getCod_dist());
			pst.setString(6, a.getEmail_admi());
			pst.setString(7, a.getUsuario_admi());
			pst.setString(8, a.getClave_admi());
			pst.setInt(9, a.getID_cargo());
			pst.setDouble(10, a.getSueldo());

			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia registrar empleado " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar" + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int actualizarAdministrador(AdministradorDTO a) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "update administrador set nom_admi = ?, ape_admi = ?, DNI_admi = ?,\r\n"
					+ "fechNac_admi = ?, cod_dist = ?,\r\n"
					+ "email_admi = ?, usuario_admi = ?, clave_Admi = ?, ID_cargo = ?,\r\n"
					+ "sueldo= ? where ID_admi = ?";

			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNom_admi());
			pst.setString(2, a.getApe_admi());
			pst.setString(3, a.getDNI_admi());
			pst.setString(4, a.getFechNac_admi());
			pst.setInt(5, a.getCod_dist());
			pst.setString(6, a.getEmail_admi());
			pst.setString(7, a.getUsuario_admi());
			pst.setString(8, a.getClave_admi());
			pst.setInt(9, a.getID_cargo());
			pst.setDouble(10, a.getSueldo());
			pst.setString(11, a.getID_admi());

			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia actualizar empleado " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar" + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminarAdministrador(String a) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "delete from administrador where ID_admi = ? ";

			pst = con.prepareStatement(sql);

			pst.setString(1, a);

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error en la sentencia eliminar administrador" + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar" + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public AdministradorDTO buscarAdministrador(String a) {

		AdministradorDTO lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from administrador where ID_admi = ? ";

			pst = con.prepareStatement(sql);
			pst.setString(1, a);
			rs = pst.executeQuery();

			lista = new AdministradorDTO();

			if (rs.next()) {
				lista.setID_admi(rs.getString(1));
				lista.setNom_admi(rs.getString(2));
				lista.setApe_admi(rs.getString(3));
				lista.setDNI_admi(rs.getString(4));
				lista.setFechNac_admi(rs.getString(5));
				lista.setCod_dist(rs.getInt(6));
				lista.setEmail_admi(rs.getString(7));
				lista.setUsuario_admi(rs.getString(8));
				lista.setClave_admi(rs.getString(9));
				lista.setID_cargo(rs.getInt(10));
				lista.setSueldo(rs.getDouble(11));

			}
		} catch (Exception e) {
			System.out.println("Error al buscar administrador" + e.getLocalizedMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public AdministradorDTO validar(String x, String y) {

		AdministradorDTO a = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select *  from administrador where usuario_admi = ? and clave_admi = ?";

			pst = con.prepareStatement(sql);

			pst.setString(1, x);
			pst.setString(2, y);
			rs = pst.executeQuery();

			if (rs.next()) {
				a = new AdministradorDTO();
				a.setID_admi(rs.getString(1));
				a.setNom_admi(rs.getString(2));
				a.setApe_admi(rs.getString(3));
				a.setDNI_admi(rs.getString(4));
				a.setFechNac_admi(rs.getString(5));
				a.setCod_dist(rs.getInt(6));
				a.setEmail_admi(rs.getString(7));
				a.setUsuario_admi(rs.getString(8));
				a.setClave_admi(rs.getString(9));
				a.setID_cargo(rs.getInt(10));
				a.setSueldo(rs.getDouble(11));

			}

		} catch (Exception e) {
			System.out.println("Error al validar administrador" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return a;
	}

	@Override
	public ArrayList<DistritoDTO> listaDistritos() {

		ArrayList<DistritoDTO> lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from DISTRITO";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ArrayList<DistritoDTO>();

			while (rs.next()) {
				DistritoDTO d = new DistritoDTO();
				d.setCodigoDist(rs.getInt(1));
				d.setNombreDist(rs.getString(2));

				lista.add(d);

			}

		} catch (Exception e) {

			System.out.println("Error al listar los distritos :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ArrayList<CargoDTO> listaCargos() {

		ArrayList<CargoDTO> lista = new ArrayList<CargoDTO>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from cargo";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<CargoDTO>();

			while (rs.next()) {
				CargoDTO d = new CargoDTO();
				d.setIdcargo(rs.getInt(1));
				d.setDescripcion(rs.getString(2));
				lista.add(d);
			}
		} catch (Exception e) {
			System.out.println("Error al listar cargos" + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public ArrayList<AdministradorDTO> listadoAdministradores(String a) {

		ArrayList<AdministradorDTO> lista = new ArrayList<AdministradorDTO>();

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select a.id_admi,a.nom_admi,a.ape_admi, a.DNI_admi, a.fechNac_admi, d.nom_dist,\r\n" + 
					"a.email_admi,a.usuario_admi,c.nom_cargo,a.sueldo\r\n" + 
					"from administrador a inner join distrito d \r\n" + 
					"on a.cod_dist = d.cod_dist\r\n" + 
					"inner join cargo c\r\n" + 
					"on a.id_cargo = c.id_Cargo\r\n" + 
					"where nom_admi like '%" + a + "%'\r\n" + 
					"order by a.nom_admi;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			lista = new ArrayList<AdministradorDTO>();

			while (rs.next()) {
				AdministradorDTO ad = new AdministradorDTO();
				ad.setID_admi(rs.getString(1));
				ad.setNom_admi(rs.getString(2));
				ad.setApe_admi(rs.getString(3));
				ad.setDNI_admi(rs.getString(4));
				ad.setFechNac_admi(rs.getString(5));
				ad.setNom_distrito(rs.getString(6));
				ad.setEmail_admi(rs.getString(7));
				ad.setUsuario_admi(rs.getString(8));
				ad.setNom_cargo(rs.getString(9));
				ad.setSueldo(rs.getDouble(10));

				lista.add(ad);

			}
		} catch (Exception e) {
			System.out.println("Error al listar los administradores por like" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}

		return lista;
	}

	@Override
	public ArrayList<AdministradorDTO> listaNormalAdministradores() {
		
		
		ArrayList<AdministradorDTO>lista = new ArrayList<AdministradorDTO>();
		
		PreparedStatement pst = null;
		Connection con = null;
		ResultSet rs = null;
		
		try {
			con = MySQLConexion.getConexion();
			String sql = "select a.id_admi,a.nom_admi,a.ape_admi, a.DNI_admi, a.fechNac_admi, d.nom_dist,\r\n" + 
					"a.email_admi,a.usuario_admi,c.nom_cargo,a.sueldo\r\n" + 
					"from administrador a inner join distrito d \r\n" + 
					"on a.cod_dist = d.cod_dist\r\n" + 
					"inner join cargo c\r\n" + 
					"on a.id_cargo = c.id_Cargo\r\n" + 
					"order by a.nom_admi ";
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			/*EN SENTENCIAS DE CONSULTA O VALIDACION, TRANSFERIR LOS DATOS*/
			lista = new ArrayList<AdministradorDTO>();
			
			while(rs.next()) {
				AdministradorDTO adm = new AdministradorDTO();
				adm.setID_admi(rs.getString(1));
				adm.setNom_admi(rs.getString(2));
				adm.setApe_admi(rs.getString(3));
				adm.setDNI_admi(rs.getString(4));
				adm.setFechNac_admi(rs.getString(5));
				adm.setNom_distrito(rs.getString(6));
				adm.setEmail_admi(rs.getString(7));
				adm.setUsuario_admi(rs.getString(8));
				adm.setNom_cargo(rs.getString(9));
				adm.setSueldo(rs.getDouble(10));
				
				lista.add(adm);
			}
			
		} catch (Exception e) {
			System.out.println("Error al listar administradores" + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(con);
		}
		
		
		return lista;
	}

}
