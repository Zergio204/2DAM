
public class Secretaria {
    private int aprobados = 0;
    private final int maxAprobados = 10;

    public synchronized boolean entregarAprobado() {
        if (aprobados < maxAprobados) {
            aprobados++;
            return true;
        }
        return false;
    }
}
