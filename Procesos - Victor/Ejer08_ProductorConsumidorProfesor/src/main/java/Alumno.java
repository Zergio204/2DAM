
class Alumno extends Thread {
    private Secretaria secretaria;
    private int id;

    public Alumno(Secretaria secretaria, int id) {
        this.secretaria = secretaria;
        this.id = id;
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