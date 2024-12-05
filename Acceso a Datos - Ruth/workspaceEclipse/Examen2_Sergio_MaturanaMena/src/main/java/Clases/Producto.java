package Clases;

public class Producto {
    private String ref;
    private String descripcion;
    private double precio;

    public Producto(String ref, String descripcion, double precio) {
        this.ref = ref;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
