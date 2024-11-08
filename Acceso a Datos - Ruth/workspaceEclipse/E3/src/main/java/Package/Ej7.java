package Package;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Servlet implementation class Ej7
 */
@WebServlet("/Ej7")
public class Ej7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Estadísticas almacenadas en el contexto de la aplicación
    private HashMap<String, Integer> estadisticas = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		estadisticas.put("Fiebre", 0);
        estadisticas.put("Tos Seca", 0);
        estadisticas.put("Diarrea", 0);
        estadisticas.put("Perdida de Olfato", 0);
        estadisticas.put("Dolor Muscular", 0);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] sintomas = request.getParameterValues("sintomas");
        boolean yaRealizado = false;

        // Verificar si el usuario ya hizo el test (mediante cookies)
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("testRealizado") && cookie.getValue().equals("true")) {
                    yaRealizado = true;
                    break;
                }
            }
        }

        response.setContentType("text/html");

        if (yaRealizado) {
        	response.getWriter().append("<html><body>");
        	response.getWriter().append("<h2>Usted ya ha realizado el test. No puede repetirlo.</h2>");
        	response.getWriter().append("<a href='html7.html'>Volver</a>");
        	response.getWriter().append("</body></html>");
        } else {
            // Actualizar estadísticas
            if (sintomas != null) {
                for (String sintoma : sintomas) {
                    estadisticas.put(sintoma, estadisticas.get(sintoma) + 1);
                }
            }

            // Crear cookie para marcar que ya ha realizado el test
            Cookie testRealizado = new Cookie("testRealizado", "true");
            response.addCookie(testRealizado);

            // Mostrar estadísticas
            response.getWriter().append("<html><body>");
            response.getWriter().append("<h2>Estadísticas de síntomas</h2>");
            response.getWriter().append("<table border='1'>");
            response.getWriter().append("<tr><th>Síntoma</th><th>Número de Personas</th></tr>");
            for (String sintoma : estadisticas.keySet()) {
            	response.getWriter().append("<tr><td>" + sintoma + "</td><td>" + estadisticas.get(sintoma) + "</td></tr>");
            }
            response.getWriter().append("</table>");
            response.getWriter().append("<a href='html7.html'>Volver</a>");
            response.getWriter().append("</body></html>");

        }
	}

}
