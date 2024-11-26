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
		Persona persona = new Persona(request.getParameter("dni"), request.getParameter("nombre"), request.getParameter("apellidos"), request.getParameter("direccion"), request.getParameter("telefono"), request.getParameter("correo"));

        request.setAttribute("persona", persona);
        request.getRequestDispatcher("MostrarPersona.jsp").forward(request, response);
	}

}
