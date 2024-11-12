package paqueteServlet;

public class Incidencia {
    private int codigo;
    private String tema;
    private String descripcion;

    public Incidencia(int codigo, String tema, String descripcion) {
        this.codigo = codigo;
        this.tema = tema;
        this.descripcion = descripcion;
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

