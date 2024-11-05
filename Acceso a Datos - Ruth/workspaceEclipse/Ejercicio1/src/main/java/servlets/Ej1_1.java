package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ej1
 */
@WebServlet("/Ej1")
public class Ej1_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej1_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain");
		String saluda=request.getParameter("saludo")!=null?"HOLA MUNDO":"";
		response.getWriter().append(saluda);
		
		
		if(!saluda.equals("HOLA MUNDO")) {
			switch((request.getParameter("idioma")!=null)?request.getParameter("idioma"):"") {
			case ("espanol"):
				response.getWriter().append("Hola Mundo!");
				break;
			case ("english"):
				response.getWriter().append("Hello World!");
				break;
			default:
				response.getWriter().append("El idioma no está en nuestra base de datos");
			}
		}else {
			response.getWriter().append("No hay parametro idioma");
		}
		
		
		
		
	}

}
