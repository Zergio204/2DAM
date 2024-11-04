package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ej1_2
 */
@WebServlet("/Ej1_2")
public class Ej1_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej1_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idioma=request.getParameter("idioma");
		
		if(idioma!=null) {
			switch(idioma) {
				case("espanol"):
					response.getWriter().append("Hola Mundo!");
					break;
				case("ingles"):
					response.getWriter().append("Hello World!");
					break;
				case("italiano"):
					response.getWriter().append("Ciao a tutti!");
					break;
				case("frances"):
					response.getWriter().append("Bonjour Tout!");
					break;
				default:
					response.getWriter().append("ERROR. El idioma no está en la base de Datos");
			}
		}else {
			response.getWriter().append("No ha seleccionado un idioma.");
		}
	}

}
