

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Ejer1")
public class Ejer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Ejer1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("<html><body><table>")
							.append("<tr><td>First Name</td><td>Last Name</td><td>Age</td><td>Email Address</td><td>Position Available I</td><td>Position Available II</td><td>Programming Languages</td></tr>")
							.append("<tr><td>" + request.getParameter("nombre") + "</td><td>" + request.getParameter("apellido") + "</td><td>" + request.getParameter("edad") + "</td><td>" + request.getParameter("email") + "</td>")
							.append("<td>" + request.getParameterValues("posicion1").toString() + "</td><td>" + request.getParameter("posicion2") + "</td><td>" + request.getParameterValues("lenguaje").toString() + "</td></tr>")
							.append("</table></body></html>");
	}

}
