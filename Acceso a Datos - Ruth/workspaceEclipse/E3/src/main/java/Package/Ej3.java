package Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ej3
 */
@WebServlet("/Ej3")
public class Ej3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion = request.getParameter("accion");
        String libros = "";

        // Obtener cookies actuales
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("libros")) {
                    libros = cookie.getValue();
                }
            }
        }

        response.setContentType("text/html");

        if (accion.equals("Sigue comprando")) {
            String nuevoLibro = request.getParameter("libro");
            libros += nuevoLibro + ",";
            Cookie cookie = new Cookie("libros", libros);
            response.addCookie(cookie);
            response.sendRedirect("html3.html");
        } else if (accion.equals("Ver compra")) {
        	response.getWriter().append("<html><body>");
        	response.getWriter().append("<h2>Libros comprados:</h2>");
        	response.getWriter().append("<p>" + libros + "</p>");
            Cookie cookie = new Cookie("libros", "");
            cookie.setMaxAge(0); // Eliminar la cookie
            response.addCookie(cookie);
            response.getWriter().append("<a href='html3.html'>Volver a la librería</a>");
            response.getWriter().append("</body></html>");
        }

	}

}
