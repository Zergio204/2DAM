package banco;

public class Alumno implements Runnable {

	private final int id;
    private final Secretaria secretaria;

    public Alumno(int id, Secretaria secretaria) {
        this.id = id;
        this.secretaria = secretaria;
    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean aprobado = secretaria.obtenerAprobado(id);
        if (!aprobado) {
            System.out.println("Soy el alumno" + id + " y no he aprobado.");
        }
	}

}
