

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletBienvenida2
 */
@WebServlet("/ServletBienvenida2")
public class ServletBienvenida2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBienvenida2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String num = request.getParameter("numero");
		
		response.getWriter().append("<html><body><hr><h1>Tabla de multiplicar del " + num + "</h1>")
							.append("<hr>")
							.append("<table border='1' style='background-color: " + request.getParameter("color") + "'>");
							for (int i = 0; i < 10 ; i++) {
								response.getWriter().append("<tr>")
													.append("<td>2" + " x " + i + "</td>")
													.append("<td>" + (2*i) + "</td>")
													.append("</tr>");
							}
		response.getWriter().append("</table>")
							.append("<hr>")
							.append("<a href='index2.html'>Volver</a> </body></html>");
	}

}
