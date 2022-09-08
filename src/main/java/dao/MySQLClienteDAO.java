package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLConexion;
import entities.ClienteDTO;
import entities.DistritoDTO;
import interfaces.ClienteDAO;

public class MySQLClienteDAO implements ClienteDAO {

	@Override
	public int registrarCliente(ClienteDTO c) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "insert into CLIENTE VALUES (genera_cliente(),?,?,?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, c.getNroDoc());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getApellido());
			pst.setString(4, c.getDireccion());
			pst.setInt(5, c.getCoddist());
			pst.setString(6, c.getCorreo());
			pst.setString(7, c.getClave());
			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia registrar " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		}

		return rs;

	}

	@Override
	public int actualizarCliente(ClienteDTO c) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "update cliente set DNI_cli =?,nom_cli=?,ape_cli=?,direc_cli=?,cod_dist=?, "
					+ " email_cli=?,clave_cli=? where cod_cli=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, c.getNroDoc());
			pst.setString(2, c.getNombre());
			pst.setString(3, c.getApellido());
			pst.setString(4, c.getDireccion());
			pst.setInt(5, c.getCoddist());
			pst.setString(6, c.getCorreo());
			pst.setString(7, c.getClave());
			pst.setString(8, c.getCodigo());

			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia actualizar " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		}

		return rs;

	}

	@Override
	public int eliminarCliente(String c) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "delete FROM CLIENTE where cod_cli=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, c);

			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia eliminar " + e.getMessage());

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		}

		return rs;

	}

	@Override
	public ArrayList<ClienteDTO> listadolikeClientes(String c) {

		ArrayList<ClienteDTO> lista = null;
		// plantilla BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = " select  c.cod_cli, c.DNI_cli, c.nom_cli, c.ape_cli,c.direc_cli,d.nom_dist,c.email_cli\r\n"
					+ "  from cliente c join distrito d\r\n" + "  on c.cod_dist= d.cod_dist\r\n"
					+ "  where  nom_cli  like  '%" + c + "%'";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ArrayList<ClienteDTO>();

			while (rs.next()) {
				ClienteDTO p = new ClienteDTO();
				p.setCodigo(rs.getString(1));
				p.setNroDoc(rs.getString(2));
				p.setNombre(rs.getString(3));
				p.setApellido(rs.getString(4));
				p.setDireccion(rs.getString(5));
				p.setNom_dist(rs.getString(6));
				p.setCorreo(rs.getString(7));

				lista.add(p);

			}

		} catch (Exception e) {

			System.out.println("Error al listar a los clientes por like :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ClienteDTO buscarCliente(String c) {

		ClienteDTO lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from CLIENTE where cod_cli=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, c);
			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ClienteDTO();

			while (rs.next()) {
				lista.setCodigo(rs.getString(1));
				lista.setNroDoc(rs.getString(2));
				lista.setNombre(rs.getString(3));
				lista.setApellido(rs.getString(4));
				lista.setDireccion(rs.getString(5));
				lista.setCoddist(rs.getInt(6));
				lista.setCorreo(rs.getString(7));
				lista.setClave(rs.getString(8));
			}
		} catch (Exception e) {

			System.out.println("Error al buscar al cliente : " + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ArrayList<ClienteDTO> listadoClientes() {

		ArrayList<ClienteDTO> lista = null;
		// plantilla BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = " select  c.cod_cli, c.DNI_cli, c.nom_cli, c.ape_cli,c.direc_cli,d.nom_dist,c.email_cli\r\n"
					+ "  from cliente c join distrito d\r\n" + "  on c.cod_dist= d.cod_dist";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ArrayList<ClienteDTO>();

			while (rs.next()) {
				ClienteDTO p = new ClienteDTO();
				p.setCodigo(rs.getString(1));
				p.setNroDoc(rs.getString(2));
				p.setNombre(rs.getString(3));
				p.setApellido(rs.getString(4));
				p.setDireccion(rs.getString(5));
				p.setNom_dist(rs.getString(6));
				p.setCorreo(rs.getString(7));
				lista.add(p);

			}

		} catch (Exception e) {

			System.out.println("Error al listar a los clientes :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ClienteDTO validar(String x, String y) {

		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		ClienteDTO c = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_validaAcceso (?,?)}";
			pst = con.prepareStatement(sql);

			// Obs 1. Si la sentencia tiene parámetros, realizar el seteo

			pst.setString(1, x);
			pst.setString(2, y);

			rs = pst.executeQuery(); // Obs 2. Depende de la consulta

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			if (rs.next()) {
				c = new ClienteDTO();
				c.setCodigo(rs.getString(1));
				c.setNroDoc(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setApellido(rs.getString(4));
				c.setDireccion(rs.getString(5));
				c.setCoddist(rs.getInt(6));
				c.setCorreo(rs.getString(7));
				c.setClave(rs.getString(8));

			}

		} catch (Exception e) {

			System.out.println("Error al validar cliente :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return c;

	}

	@Override
	public ArrayList<DistritoDTO> listadistritos() {

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

}
