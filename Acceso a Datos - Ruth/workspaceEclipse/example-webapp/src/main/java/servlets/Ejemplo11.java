package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo11
 */
@WebServlet("/Ejemplo11")
public class Ejemplo11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int val = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		val = Integer.parseInt(request.getParameter("param"));
//		//Mostrar proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//		//Simulación operativa antes de volver a utilizar la variable
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Mostrar el proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//	}
    
    //Cambian la variable de clase a variable local del doget
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		int val = 0;
//		
//		val = Integer.parseInt(request.getParameter("param"));
//		//Mostrar proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//		//Simulación operativa antes de volver a utilizar la variable
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Mostrar el proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//	}
    
    //Sincronizar el metodo de servicio (se puede crear cuello de botella)
//	protected synchronized void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		int val = 0;
//		
//		val = Integer.parseInt(request.getParameter("param"));
//		//Mostrar proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//		//Simulación operativa antes de volver a utilizar la variable
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Mostrar el proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//	}
    
    //Si ponemos el metodo externo, el resto del codigo se puede seguir ejecutando
//    public synchronized void prueba(HttpServletRequest request) {
//    	int val = 0;
//		
//		val = Integer.parseInt(request.getParameter("param"));
//		//Mostrar proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//		
//		//Simulación operativa antes de volver a utilizar la variable
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//Mostrar el proceso que se está ejecutando
//		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
//    }
//    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		System.out.println("Comienzo de la sincronización");
//		prueba(request);
//		System.out.println("Final de la sincronizacion");
//		
//	}
    
    //Objeto candado (la mejor opcion)
    private final Object lock = new Object();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Simulación operativa antes de volver a utilizar la variable
		try {
			synchronized (lock) {
				val = Integer.parseInt(request.getParameter("param"));
				//Mostrar proceso que se está ejecutando
				System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
				Thread.sleep(10000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Mostrar el proceso que se está ejecutando
		System.out.println("Thread: " + Thread.currentThread().getName() + "usa el valor" + val);
		
	}

}
