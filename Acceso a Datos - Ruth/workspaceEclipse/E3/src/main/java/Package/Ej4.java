package Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ej4
 */
@WebServlet("/Ej4")
public class Ej4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String action = request.getParameter("action");
        response.setContentType("text/html");

        if (action.equals("Acceso")) {
            Integer contador = (Integer) session.getAttribute("contador");
            if (contador == null) {
                contador = 1;
            } else {
                contador++;
            }
            session.setAttribute("contador", contador);
            response.getWriter().append("<html><body>");
            response.getWriter().append("<h2>Desde la última vez ha accedido " + contador + " veces</h2>");
            response.getWriter().append("<a href='html4.html'>Volver</a>");
            response.getWriter().append("</body></html>");
        } else if (action.equals("Nueva sesion")) {
            session.invalidate(); // Invalidar sesión actual
            session = request.getSession(); // Crear nueva sesión
            session.setAttribute("contador", 1);
            response.getWriter().append("<html><body>");
            response.getWriter().append("<h2>Es la primera vez que accede a la web</h2>");
            response.getWriter().append("<a href='html4.html'>Volver</a>");
            response.getWriter().append("</body></html>");
        }

	}

}
