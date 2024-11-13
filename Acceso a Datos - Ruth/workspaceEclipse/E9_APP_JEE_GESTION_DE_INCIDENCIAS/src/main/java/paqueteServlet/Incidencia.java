package paqueteServlet;

import java.util.HashSet;
import java.util.Set;

public class Incidencia {
    private static Set<Integer> usedCodes = new HashSet<>();
    private int codigo;
    private String descripcion;
    private String tema;

    public Incidencia(String tema, String descripcion) {
        this.codigo = generarCodigoUnico();
        this.tema = tema;
        this.descripcion = descripcion;
    }

    private int generarCodigoUnico() {
        int codigo;
        do {
            codigo = (int) (Math.random() * 20) + 1;
        } while (usedCodes.contains(codigo));
        usedCodes.add(codigo);
        return codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTema() {
        return tema;
    }

    public String getDescripcion() {
        return descripcion;
    }
}