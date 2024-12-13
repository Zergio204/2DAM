package com.gf.webapp.matriculas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gf.webapp.matriculas.entities.Alumno;
import com.gf.webapp.matriculas.resources.ConexionBD;

public class AlumnoDAO {

	public static int insert(Alumno a) throws SQLException {
		String sql = "INSERT INTO matriculas.alumnos (nMatricula, nombre, apellidos, ciclo, curso) VALUES (?,?,?,?,?)";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getIdMatricula());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellidos());
            ps.setString(4, a.getCiclo());
            ps.setString(5, a.getCurso());
            return ps.executeUpdate();
        }
	}

	public static Alumno select(Alumno a) throws SQLException {

		String sql = "SELECT * FROM matriculas.alumnos WHERE nMatricula=?";
        Alumno alumno = null;
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getIdMatricula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alumno = new Alumno(
                    rs.getString("nombre"), 
                    rs.getString("apellidos"), 
                    rs.getString("curso"), 
                    rs.getString("ciclo")
                );
            }
        }
        return alumno;

	}
	
	public static int update(Alumno a) throws SQLException {
        String sql = "UPDATE matriculas.alumnos SET nombre=?, apellidos=?, ciclo=?, curso=? WHERE nMatricula=?";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellidos());
            ps.setString(3, a.getCiclo());
            ps.setString(4, a.getCurso());
            ps.setString(5, a.getIdMatricula());
            return ps.executeUpdate();
        }
    }
	
	public static int delete(Alumno a) throws SQLException {
        String sql = "DELETE FROM matriculas.alumnos WHERE nMatricula=?";
        try (Connection conn = ConexionBD.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getIdMatricula());
            return ps.executeUpdate();
        }
    }

}
