package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletPersona
 */

@WebServlet("/ServletPersona")
public class ServletPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
        persona.setDni(request.getParameter("dni"));
        persona.setNombre(request.getParameter("nombre"));
        persona.setApellidos(request.getParameter("apellidos"));
        persona.setDireccion(request.getParameter("direccion"));
        persona.setTelefono(request.getParameter("telefono"));
        persona.setCorreo(request.getParameter("correo"));

        request.setAttribute("persona", persona);
        request.getRequestDispatcher("MostrarPersona.jsp").forward(request, response);
	}

}
