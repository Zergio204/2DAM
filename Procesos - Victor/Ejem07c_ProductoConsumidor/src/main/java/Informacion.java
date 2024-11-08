import java.util.Random;

public class Informacion {
    private int dato;
    Random r = new Random();
    boolean producido = false;

    public synchronized void producir() {
        while (producido) {  
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dato = r.nextInt();
        producido = true;
        notify();
    }

    public synchronized int consumir() {
        while (!producido) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producido = false;
        notify();
        return dato;
    }
}

