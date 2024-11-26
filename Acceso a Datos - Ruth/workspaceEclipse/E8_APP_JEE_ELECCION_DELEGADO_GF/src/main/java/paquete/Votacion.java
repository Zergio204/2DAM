package paquete;
public class Votacion {
    private String nombre;
    private int votos;

    public Votacion(String nombre) {
        this.nombre = nombre;
        this.votos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void incrementarVotos() {
        this.votos++;
    }

    public void resetVotos() {
        this.votos = 0;
    }
}
