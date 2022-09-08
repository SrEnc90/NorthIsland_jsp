package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLConexion;
import entities.CategoriaDTO;
import entities.ProductoDTO;
import interfaces.ProductoDAO;

public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public int registrarProducto(ProductoDTO p) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "insert into PRODUCTO values (genera_producto(),?,?,?,?,? );";

			pst = con.prepareStatement(sql);

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getDescripcion());
			pst.setInt(3, p.getCategoria());
			pst.setInt(4, p.getStock());
			pst.setDouble(5, p.getPrecio());

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
	public int actualizarProducto(ProductoDTO p) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "update producto set nombre=?, descripcion=?, cod_cat=?, stock=?, precio=? where cod_pro=?";

			pst = con.prepareStatement(sql);

			pst.setString(1, p.getNombre());
			pst.setString(2, p.getDescripcion());
			pst.setInt(3, p.getCategoria());
			pst.setInt(4, p.getStock());
			pst.setDouble(5, p.getPrecio());
			pst.setString(6, p.getCodigo());

			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia  actualizar " + e.getMessage());

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
	public int eliminarProducto(String p) {

		int rs = 0;

		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "delete from PRODUCTO where cod_pro=?";

			pst = con.prepareStatement(sql);
			pst.setString(1, p);

			rs = pst.executeUpdate();

		} catch (Exception e) {

			System.out.println("Error en la sentencia  eliminar " + e.getMessage());

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
	public ArrayList<ProductoDTO> listaProductos() {

		ArrayList<ProductoDTO> lista = null;
		// plantilla BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select p.cod_pro, p.nombre, p.descripcion, c.desc_cat, p.stock, p.precio\r\n"
					+ "from producto p inner join categoria c\r\n" + "on p.cod_cat = c.cod_cat ";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ArrayList<ProductoDTO>();

			while (rs.next()) {
				ProductoDTO p = new ProductoDTO();
				p.setCodigo(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setNom_categoria(rs.getString(4));
				p.setStock(rs.getInt(5));
				p.setPrecio(rs.getDouble(6));
				lista.add(p);

			}

		} catch (Exception e) {

			System.out.println("Error al listar productos :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ProductoDTO buscarProducto(String p) {

		ProductoDTO lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from PRODUCTO where cod_pro= ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, p);
			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ProductoDTO();

			if (rs.next()) {
				lista.setCodigo(rs.getString(1));
				lista.setNombre(rs.getString(2));
				lista.setDescripcion(rs.getString(3));
				lista.setCategoria(rs.getInt(4));
				lista.setStock(rs.getInt(5));
				lista.setPrecio(rs.getDouble(6));

			}
		} catch (Exception e) {

			System.out.println("Error al buscar el producto : " + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ArrayList<CategoriaDTO> listaCategorias() {

		ArrayList<CategoriaDTO> lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from CATEGORIA";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ArrayList<CategoriaDTO>();

			while (rs.next()) {
				CategoriaDTO p = new CategoriaDTO();
				p.setCodigo(rs.getInt(1));
				p.setNombre(rs.getString(2));
				lista.add(p);

			}

		} catch (Exception e) {

			System.out.println("Error al listar categorias :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

	@Override
	public ArrayList<ProductoDTO> listaXlike(String p) {

		ArrayList<ProductoDTO> lista = null;
		// plantilla BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select p.cod_pro, p.nombre, p.descripcion, c.desc_cat, p.stock, p.precio \r\n" + 
					"from producto p inner join categoria c on p.cod_cat = c.cod_cat \r\n" + 
					"where desc_cat like '%" +p+ "%'" ;
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			// Obs 3. En sentencias de consulta o validacion, transferir los datos
			lista = new ArrayList<ProductoDTO>();

			while (rs.next()) {
				ProductoDTO pr = new ProductoDTO();
				pr.setCodigo(rs.getString(1));
				pr.setNombre(rs.getString(2));
				pr.setDescripcion(rs.getString(3));
				pr.setNom_categoria(rs.getString(4));
				pr.setStock(rs.getInt(5));
				pr.setPrecio(rs.getDouble(6));
				lista.add(pr);

			}

		} catch (Exception e) {

			System.out.println("Error al listar productos :" + e.getMessage());
		} finally {

			MySQLConexion.closeConexion(con);
		}

		return lista;

	}

}
