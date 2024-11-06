
class Secretaria {
    private int aprobados = 0;
    private final int MAX_APROBADOS = 10;

    public synchronized boolean entregarAprobado() {
        if (aprobados < MAX_APROBADOS) {
            aprobados++;
            return true;
        }
        return false;
    }
}