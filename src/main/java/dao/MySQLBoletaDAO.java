package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.MySQLConexion;
import entities.BoletaDTO;
import entities.EstadoBolDTO;
import entities.RepBoletaDTO;
import interfaces.BoletaDAO;

public class MySQLBoletaDAO implements BoletaDAO {

	@Override
	public ArrayList<RepBoletaDTO> reportefechaboleta(String x, String y) {
		
		

		Connection con= null;
		ArrayList<RepBoletaDTO> lista = new ArrayList<RepBoletaDTO>();
		ResultSet rs= null;
		PreparedStatement pst = null;
		con=MySQLConexion.getConexion();
		try {
		String sql=("{call usp_INTERVALO_BOLETA('"+x+"','"+y+"')}");
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()) {
			RepBoletaDTO f= new RepBoletaDTO();
			 f.setNumerobol(rs.getString(1));
			 f.setFecha(rs.getString(2));
			 f.setCliente(rs.getString(3));
			 f.setDesestado(rs.getString(4));
			 f.setSubtotal(rs.getString(5));
			 f.setIgv(rs.getString(6));
			 f.setTotal(rs.getString(7));
			 lista.add(f);
		}
		
		}catch (Exception e) {
			System.out.println("Error al buscar boleta por meses "+e.getMessage()); 
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		}
		return lista;
	
		
	}

	@Override
	public ArrayList<BoletaDTO> reporteestadoboleta(int est) {
		

		Connection con= null;
		ArrayList<BoletaDTO> lista = new ArrayList<BoletaDTO>();
		ResultSet rs= null;
		PreparedStatement pst = null;
		con=MySQLConexion.getConexion();
		try {
		String sql="select * from boleta where cod_est = ? ;";
		pst=con.prepareStatement(sql);
		pst.setInt(1, est);
		rs=pst.executeQuery();
		while(rs.next()) {
			BoletaDTO f= new BoletaDTO();
			 f.setNumerobol(rs.getString(1));
			 f.setFecha(rs.getString(2));
			 f.setCliente(rs.getString(3));
			 f.setEstado(rs.getInt(4));
			 f.setSubtotal(rs.getDouble(5));
			 f.setIgv(rs.getDouble(6));
			 f.setTotal(rs.getDouble(7));
			 lista.add(f);
		}
		
		}catch (Exception e) {
			System.out.println("Error al buscar boleta por meses "+e.getMessage()); 
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		} return lista;
	
		
	}

	@Override
	public ArrayList<EstadoBolDTO> listaestadosBol() {
		

		Connection con= null;
		ArrayList<EstadoBolDTO> lista = new ArrayList<EstadoBolDTO>();
		ResultSet rs= null;
		PreparedStatement pst = null;
		con=MySQLConexion.getConexion();
		try {
		String sql="select * from estadoBol";
		pst=con.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()) {
			EstadoBolDTO f= new EstadoBolDTO();
			 f.setCodigo(rs.getInt(1));
			 f.setDescripcion(rs.getString(2));

			 lista.add(f);
		     }
		}catch (Exception e) {
			System.out.println("Error al listar los estados de boleta "+e.getMessage()); 
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		} return lista;
		
		
		
	}

}
