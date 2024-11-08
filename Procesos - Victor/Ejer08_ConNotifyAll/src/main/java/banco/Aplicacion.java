package banco;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
        Secretaria secretaria = new Secretaria();
        
        List<Thread> alumnos = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Thread alumno = new Thread(new Alumno(i, secretaria));
            alumnos.add(alumno);
            alumno.start();
        }

        Profesor profesor = new Profesor();
        profesor.iniciar(secretaria);

        for (Thread alumno : alumnos) {
            alumno.join();
        }
	}

}
