package com.gf.webapp.matriculas.ln;

import java.sql.SQLException;

import com.gf.webapp.matriculas.dao.AlumnoDAO;
import com.gf.webapp.matriculas.entities.Alumno;

public class AlumnoLN {
    public static String alta(Alumno a) throws SQLException {
        if (AlumnoDAO.select(a) == null) {
            int resultado = AlumnoDAO.insert(a);
            return resultado > 0 ? "El alumno se ha guardado correctamente." : "Error al guardar el alumno.";
        } else {
            return "El alumno ya existe.";
        }
    }

    public static String baja(Alumno a) throws SQLException {
        Alumno alumnoExistente = AlumnoDAO.select(a);
        if (alumnoExistente != null) {
            int resultado = AlumnoDAO.delete(a);
            return resultado > 0 ? "El alumno ha sido eliminado correctamente." : "No se pudo eliminar el alumno.";
        } else {
            return "El alumno no existe.";
        }
    }

    public static String actualiza(Alumno a) throws SQLException {
        Alumno alumnoExistente = AlumnoDAO.select(a);
        if (alumnoExistente != null) {
            int resultado = AlumnoDAO.update(a);
            return resultado > 0 ? "El alumno ha sido actualizado correctamente." : "No se pudo actualizar el alumno.";
        } else {
            return "El alumno no existe, no se puede actualizar.";
        }
    }

    public static String consulta(Alumno a) throws SQLException {
        Alumno alumnoEncontrado = AlumnoDAO.select(a);
        if (alumnoEncontrado != null) {
            return "Alumno encontrado: " + 
                   "Nombre: " + alumnoEncontrado.getNombre() + ", " +
                   "Apellidos: " + alumnoEncontrado.getApellidos() + ", " +
                   "Ciclo: " + alumnoEncontrado.getCiclo() + ", " +
                   "Curso: " + alumnoEncontrado.getCurso();
        } else {
            return "El alumno no existe.";
        }
    }
}
