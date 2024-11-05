package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
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
		response.setContentType("text/html");
		response.getWriter().append("<html><body><h2>Muestra de Datos</h2>")
							.append("<table border='1'>")
							.append("<tr>")
							.append("<td>Nombre</td><td>Apellidos</td><td>Direccion</td>")
							.append("<td>Tipo de Tarjeta</td><td>Numero</td>")
							.append("</tr>")
							.append("<tr><td>" + request.getParameter("nombre") + "</td></tr>")
							.append("<tr><td>" + request.getParameter("apellidos") + "</td></tr>")
							.append("<tr><td>" + request.getParameter("direccion") + "</td></tr>")
							.append("<tr><td>" + request.getParameter("tarjeta") + "</td></tr>")
							.append("<tr><td>" + request.getParameter("numero") + "</td></tr>")
							.append("</table></body></html>");
	}

}
