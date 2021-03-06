package DAO_Tablas_db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controlador.Conexion;
import modelo.tb_salas;

public class tb_salasDAO {

	Conexion c = new Conexion();// ClaseConexi
	tb_salas u = new tb_salas();// ClaseUsuarios
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	// listar
	public List listar() {

		List<tb_salas> lista = new ArrayList<>();
		String sql = "SELECT *FROM tb_salas";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				tb_salas u = new tb_salas();
				u.setId_Sucursal(rs.getInt(1));
				u.setId_Sala(rs.getInt(2));
				u.setTb_Sala_id_Sala(rs.getInt(3));
				u.setTb_Sucursal_id_Sucursal(rs.getInt(4));
				lista.add(u);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	// metodoAgregar

	public int agregar(tb_salas u) {

		int r = 0;
		String sql = "INSERT INTO tb_salas(id_Sala, tb_Sala_id_Sala, tb_Sucursal_id_Sucursal)VALUES(?,?,?)";
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Sala());
			ps.setInt(2, u.getTb_Sala_id_Sala());
			ps.setInt(3, u.getTb_Sucursal_id_Sucursal());
			r = ps.executeUpdate();
			if (r == 1) {
				r = 1;
			} else {
				r = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	// listarId

	public tb_salas listarid(int id_Sucursal) {

		String sql = "SELECT *FROM tb_salas WHERE id_Sucursal" + id_Sucursal;
		tb_salas u = new tb_salas();
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setId_Sala(rs.getInt(2));
				u.setTb_Sala_id_Sala(rs.getInt(3));
				u.setTb_Sucursal_id_Sucursal(rs.getInt(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return u;
	}

	// actualizarTabla

	public int actualizar(tb_salas u) {
		int r = 0;
		String sql = "UPDATE tb_salas SET id_Sala=?, tb_Sala_id_Sala=?, tb_Sucursal_id_Sucursal=? WHERE id_Sucursal=?";
		try {
			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId_Sala());
			ps.setInt(2, u.getTb_Sala_id_Sala());
			ps.setInt(3, u.getTb_Sucursal_id_Sucursal());
			r = ps.executeUpdate();
			if (r == 1) {
				r = 1;
			} else {
				r = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	// eliminar
	public void delete(int id_Sucursal) {
		String sql = "DELETE FROM tb_salas WHERE id_Sucursal" + id_Sucursal;
		try {

			con = c.conectar();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
