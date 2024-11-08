package Package;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class Ej5
 */
@WebServlet("/Ej5")
public class Ej5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = getServletContext();
        Random random = new Random();

        // Generar número aleatorio del servlet
        int aleatorio = random.nextInt(10) + 1;

        // Obtener el número aleatorio almacenado en el contexto
        Integer contextoAleatorio = (Integer) context.getAttribute("contextoAleatorio");
        if (contextoAleatorio == null) {
            contextoAleatorio = random.nextInt(10) + 1;
            context.setAttribute("contextoAleatorio", contextoAleatorio);
        }

        response.setContentType("text/html");
        response.getWriter().append("<html><body>");

        if (aleatorio == contextoAleatorio) {
        	response.getWriter().append("<h2>Aleatorio: " + aleatorio + ". Contexto: " + contextoAleatorio + ". Números iguales.</h2>");
        } else {
        	response.getWriter().append("<h2>Aleatorio: " + aleatorio + ". Contexto: " + contextoAleatorio + ". Números distintos.</h2>");
        }

        // Actualizar el número en el contexto
        context.setAttribute("contextoAleatorio", aleatorio);

        response.getWriter().append("<a href='Ej5'>Volver a generar</a>");
        response.getWriter().append("</body></html>");

	}


}
