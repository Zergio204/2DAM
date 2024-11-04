package Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Ej2
 */
@WebServlet("/Ej2")
public class Ej2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String nombre = request.getParameter("nombre");

        // Obtener la lista de nombres saludados
        List<String> nombres = (List<String>) session.getAttribute("nombres");
        if (nombres == null) {
            nombres = new ArrayList<>();
        }
        nombres.add(nombre);
        session.setAttribute("nombres", nombres);

        // Generar la respuesta HTML
        response.setContentType("text/html");
        response.getWriter().append("<html><body>");
        response.getWriter().append("<h2>Hola, " + nombre + "!</h2>");
        response.getWriter().append("<h3>Usuarios saludados:</h3>");
        response.getWriter().append("<ul>");
        for (String saludo : nombres) {
        	response.getWriter().append("<li>" + saludo + "</li>");
        }
        response.getWriter().append("</ul>");
        response.getWriter().append("<a href='html2.html'>Volver</a>");
        response.getWriter().append("</body></html>");

	}

}
