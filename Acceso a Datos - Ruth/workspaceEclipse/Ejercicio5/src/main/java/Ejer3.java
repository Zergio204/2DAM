

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ejer3
 */
@WebServlet("/Ejer3")
public class Ejer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Object lock = new Object();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

			synchronized (lock) {
				HttpSession nuevaSession = request.getSession(true);
				String usuario = request.getParameter("usuario");
				nuevaSession.setAttribute("usuario", usuario);
			
	            response.getWriter().append("Usuario: " + usuario + "<br>");
	            response.getWriter().append("id de la sesión: " + nuevaSession.getId() + "<br>");
	            response.getWriter().append("Fecha de creación: " + nuevaSession.getCreationTime() + "<br>");
	            response.getWriter().append("Fecha último acceso: " + nuevaSession.getLastAccessedTime() + "<br>");
			}

		
	}

}
