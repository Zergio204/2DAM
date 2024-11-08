package Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ej6
 */
@WebServlet("/Ej6")
public class Ej6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
        String cookieName = request.getParameter("cookieName");
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");

        if (action.equals("Mostrar galletas")) {
        	response.getWriter().append("<html><body>");
            if (cookies != null) {
            	response.getWriter().append("<h2>Galletas en el navegador:</h2>");
                for (Cookie cookie : cookies) {
                	response.getWriter().append("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
                }
            } else {
            	response.getWriter().append("<h2>No hay galletas disponibles.</h2>");
            }
            response.getWriter().append("<a href='html6.html'>Volver</a>");
            response.getWriter().append("</body></html>");
        } else if (action.equals("Cocinar galleta")) {
            if (cookieName == null || cookieName.isEmpty()) {
            	response.getWriter().append("<html><body><h2>No has elegido galleta</h2><a href='html6.html'>Volver</a></body></html>");
            } else {
                Cookie nuevaCookie = new Cookie(cookieName, "Deliciosa");
                response.addCookie(nuevaCookie);
                response.getWriter().append("<html><body><h2>Galleta '" + cookieName + "' cocinada!</h2><a href='html6.html'>Volver</a></body></html>");
            }
        } else if (action.equals("Comer galleta")) {
            if (cookieName == null || cookieName.isEmpty()) {
            	response.getWriter().append("<html><body><h2>No has elegido galleta</h2><a href='html6.html'>Volver</a></body></html>");
            } else {
                Cookie cookieAEliminar = null;
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals(cookieName)) {
                            cookieAEliminar = cookie;
                        }
                    }
                }
                if (cookieAEliminar != null) {
                    cookieAEliminar.setMaxAge(0);
                    response.addCookie(cookieAEliminar);
                    response.getWriter().append("<html><body><h2>Galleta '" + cookieName + "' comida!</h2><a href='html6.html'>Volver</a></body></html>");
                } else {
                	response.getWriter().append("<html><body><h2>No hay galleta '" + cookieName + "' para comer.</h2><a href='html6.html'>Volver</a></body></html>");
                }
            }
        }

	}

}
