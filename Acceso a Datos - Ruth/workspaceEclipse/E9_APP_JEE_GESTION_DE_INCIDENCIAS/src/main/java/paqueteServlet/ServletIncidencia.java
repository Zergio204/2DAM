package paqueteServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Servlet implementation class ServletIncidencia
 */
@WebServlet("/ServletIncidencia")
public class ServletIncidencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<Incidencia> incidencias = new ArrayList<>();
    private static final Random random = new Random();

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
            request.setAttribute("mensajeError", "Tema y Descripción son obligatorios.");
            request.getRequestDispatcher("AltaIncidencia.jsp").forward(request, response);
            return;
        }

        int codigo;
        do {
            codigo = random.nextInt(20) + 1;
        } while (codigoRepetido(codigo));

        Incidencia incidencia = new Incidencia(codigo, tema, descripcion);
        incidencias.add(incidencia);

        response.sendRedirect("ConsultaIncidencia.jsp");
	}
	
	private boolean codigoRepetido(int codigo) {
        return incidencias.stream().anyMatch(incidencia -> incidencia.getCodigo() == codigo);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("incidencias", incidencias);
        request.getRequestDispatcher("ConsultaIncidencia.jsp").forward(request, response);
    }

}
