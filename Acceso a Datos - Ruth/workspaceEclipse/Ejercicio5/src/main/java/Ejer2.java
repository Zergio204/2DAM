

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class Ejer2
 */
@WebServlet("/Ejer2")
public class Ejer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int valor = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    Object lock = new Object();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		Random r = new Random();
		int[] array = new int[10];
		synchronized (lock) {
		
			for (int i = 0; i < array.length; i++) {
				array[i] = (int) (r.nextInt(100));
				valor += array[i];
			}
			for (int i = 0; i < array.length; i++) {
				valor -= array[i];
			}
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().append("El valor es: " + valor);
		
		}
		
	}


}