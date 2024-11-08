
public class Alumno extends Thread {
    private final int id;
    private final Secretaria secretaria;

    public Alumno(int id, Secretaria secretaria) {
        this.id = id;
        this.secretaria = secretaria;
    }

    @Override
    public void run() {
        if (secretaria.entregarAprobado()) {
            System.out.println("Soy el alumno " + id + " y he aprobado");
        } else {
            System.out.println("Soy el alumno " + id + " y no he aprobado");
        }
    }
}
