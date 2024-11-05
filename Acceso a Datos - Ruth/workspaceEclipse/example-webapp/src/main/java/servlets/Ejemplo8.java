package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

import java.io.IOException;

/**
 * Servlet implementation class Ejemplo8
 */
@WebServlet("/Ejemplo8")
public class Ejemplo8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo8() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int c=1;
		response.setContentType("text/plain");
		
		//Crear la sesion si no existe
		HttpSession sesion = request.getSession(true);
		
		if(sesion.getAttribute("cont")==null) {
			response.getWriter().append("HOLA DAMM \n");
		}else {
			response.getWriter().append("HOLA DE NUEVO DAMM \n");
			c= (int) sesion.getAttribute("cont");
		}
		//Reenviar la url concatenandole el jsesion id, en caso de que el navegador no acepte cookies, el jsesion va aqui
		//response.sendRedirect(response.encodeRedirectURL("Ejemplo8"));
		
		//Incremento el atributo contador en la sesion
		sesion.setAttribute("cont", c+1);
		response.getWriter().append("Accesos de la sesión: " + c + "\n")
							.append("La sesión fue creada: " + new Date(sesion.getCreationTime()) + "\n")
							.append("La sesion se identifica: " + sesion.getId() + "\n")
							.append("Se accedio a la sesion por ultima vez: " + new Date(sesion.getLastAccessedTime()) + "\n")
							.append("La sesión permanece inactiva por: " + sesion.getMaxInactiveInterval() + "\n");
		
		
	}

}
