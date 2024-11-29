package com.gf.webapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gf.webapp.matriculas.entities.Alumno;
import com.gf.webapp.matriculas.resources.ConexionBD;

public class AlumnoDAO {

	public static int insert(Alumno a) throws SQLException {
		String sql="INSERT INTO matriculas.alumnos VALUES (?,?,?,?,?)";
		
		try(Connection conn= ConexionBD.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, a.getIdmatricula());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellidos());
			ps.setString(4, a.getCurso());
			ps.setString(5, a.getCiclo());
			return ps.executeUpdate();
			
		}
		
	}
	
	public static Alumno select(Alumno a) throws SQLException {
		
		String sql = "SELECT * FROM matriculas.alumnos a WHERE a.nMatricula = ?";
		Alumno alumno = null;
		try(Connection conn= ConexionBD.getConnection()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getIdmatricula());
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                alumno = new Alumno(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
		
		}
		
		return alumno;
		
	}
	
}
