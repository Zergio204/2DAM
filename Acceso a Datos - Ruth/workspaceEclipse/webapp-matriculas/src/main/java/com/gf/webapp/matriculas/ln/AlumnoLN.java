package com.gf.webapp.matriculas.ln;

import java.sql.SQLException;

import com.gf.webapp.dao.AlumnoDAO;
import com.gf.webapp.matriculas.entities.Alumno;

public class AlumnoLN {

	//Alta de un alumno
	public static String alta(Alumno a) throws SQLException {
		
		if(AlumnoDAO.select(a)==null) {
			AlumnoDAO.insert(a);
			return "El alumno se ha guardado correctamente.";
		} else {
			return "El alumno ya existe.";
		}
		
	}
	
	//Baja de un alumno
	public static String baja(Alumno a) throws SQLException {

		if (AlumnoDAO.select(a) != null) {
			AlumnoDAO.delete(a);
			return "El alumno se ha eliminado correctamente.";
		} else {
			return "El alumno no existe.";
		}

	}
	
	//Actualización de un alumno
	public static String actualiza(Alumno a) throws SQLException {

		if (AlumnoDAO.select(a) != null) {
			AlumnoDAO.update(a);
			return "El alumno se ha actualizado correctamente.";
		} else {
			return "El alumno no existe.";
		}

	}
	
	//Consulta de un alumno
	public static Alumno consulta(Alumno a) throws SQLException {

		return AlumnoDAO.select(a);

	}
	
	
}
