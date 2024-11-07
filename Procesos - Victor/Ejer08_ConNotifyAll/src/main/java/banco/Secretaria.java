package banco;

public class Secretaria {
	private int aprobadosDisponibles = 0;
    private final int maxAprobados = 10;

    public synchronized void entregarAprobado() {
        if (aprobadosDisponibles < maxAprobados) {
            aprobadosDisponibles++;
            System.out.println("Secretaría ha entregado un aprobado. Total disponibles: " + aprobadosDisponibles);
            notifyAll();
        }
    }

    public synchronized boolean obtenerAprobado(int alumnoId) {
        while (aprobadosDisponibles == 0 && aprobadosDisponibles < maxAprobados) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (aprobadosDisponibles > 0) {
            aprobadosDisponibles--;
            System.out.println("Soy el alumno" + alumnoId + " y he aprobado.");
            return true;
        }
        return false;
    }
}
