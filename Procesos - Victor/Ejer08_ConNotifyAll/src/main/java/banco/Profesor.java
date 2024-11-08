package banco;

public class Profesor {
	public void iniciar(Secretaria secretaria) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(20);
            secretaria.entregarAprobado();
        }
    }
}
