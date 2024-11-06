
public class Aplicacion {

    public static void main(String[] args) {
        Secretaria secretaria = new Secretaria();
        int totalAlumnos = 20;

        for (int i = 1; i <= totalAlumnos; i++) {
            new Alumno(i, secretaria).start();
            try {
                Thread.sleep(20); // El profesor entrega un aprobado cada 20 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
