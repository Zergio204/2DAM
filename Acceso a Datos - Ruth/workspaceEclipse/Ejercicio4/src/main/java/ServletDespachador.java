

import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletDespachador
 */
@WebServlet("/ServletDespachador")
public class ServletDespachador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDespachador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/plain");
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		
		RequestDispatcher dispatcherBienvenida = request.getRequestDispatcher("ServletBienvenida");
		RequestDispatcher dispatcherError = request.getRequestDispatcher("ServletError");
		
		if(!usuario.isBlank() || !contrasena.isBlank()) {
			if(contrasena.equalsIgnoreCase("admin")) {
				dispatcherBienvenida.forward(request, response);
			}else {
				dispatcherError.forward(request, response);
			}
		}
		
	}

}
