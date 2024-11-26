package paqueteServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ServletIncidencia
 */
@WebServlet("/ServletIncidencia")
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Incidencia> incidencias = new ArrayList<>();

    /**
     * Default constructor. 
     */
    public ServletIncidencia() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tema = request.getParameter("tema");
        String descripcion = request.getParameter("descripcion");

        if (tema == null || tema.isEmpty() || descripcion == null || descripcion.isEmpty()) {
        	request.setAttribute("error", "Debe completar todos los campos.");
            request.getRequestDispatcher("AltaIncidencia.jsp").forward(request, response);
        } else {
            Incidencia nuevaIncidencia = new Incidencia(tema, descripcion);
            incidencias.add(nuevaIncidencia);
            getServletContext().setAttribute("incidencias", incidencias);
            request.getRequestDispatcher("AltaIncidencia.jsp").include(request, response);
        }
	}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("ConsultaIncidencia.jsp").forward(request, response);
    }

}
