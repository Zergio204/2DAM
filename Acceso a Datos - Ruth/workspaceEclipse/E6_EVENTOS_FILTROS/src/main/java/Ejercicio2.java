

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Servlet implementation class Ejercicio2
 */
@WebServlet("/Ejercicio2")
public class Ejercicio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejercicio2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
        HashMap<String, Integer> contadorVisitas = (HashMap<String, Integer>) context.getAttribute("contadorVisitas");

        response.setContentType("text/html");
        response.getWriter().append("<html><body>")
        					.append("<h1>Contador de Visitas</h1>");
        for (String url : contadorVisitas.keySet()) {
        	response.getWriter().append("<p>" + url + " ha sido visitada " + contadorVisitas.get(url) + " veces</p>");
        }
        response.getWriter().append("</body></html>");
	}

}