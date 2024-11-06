
public class Profesor {
    public static void main(String[] args) {
        Secretaria secretaria = new Secretaria();
        Alumno[] alumnos = new Alumno[20];

        for (int i = 0; i < 20; i++) {
            alumnos[i] = new Alumno(secretaria, i + 1);
            alumnos[i].start();
            try {
                Thread.sleep(20); // El profesor entrega un aprobado cada 20 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Alumno alumno : alumnos) {
            try {
                alumno.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}