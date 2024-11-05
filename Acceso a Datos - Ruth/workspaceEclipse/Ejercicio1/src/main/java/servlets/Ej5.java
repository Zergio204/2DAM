package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		response.getWriter().append("Matricula realizada correctamente!!!")
							.append("Asignaturas: " + Arrays.toString(request.getParameterValues("asignatura"))+"\n")
							.append("Sexo: " + request.getParameter("sexo"))
							.append("Extraescolares: " + Arrays.toString(request.getParameterValues("actividad")));
	}

}
