package servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
	
/**
 * Servlet implementation class Ejer2
 */
@WebServlet("/Ejer2")
public class Ejer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String tlfn = request.getParameter("tlfn");
		
		if(nombre!=null && edad!=null && tlfn!=null) {
			Persona p = new Persona(nombre,edad,tlfn);
			
			listaPersonas.add(p);
		}
		
		//meto la lista como atributo contexto
		if(!listaPersonas.isEmpty()) {
			getServletContext().setAttribute("lista", listaPersonas);

		}
		
		//creo el formulario
		response.getWriter().append("<html><head></head><body><table border='1'>");
		for (Persona persona : listaPersonas) {
			
			response.getWriter().append("<tr><td>" + persona.getNombre() + "</td><td>" + persona.getEdad() + "</td><td>" + persona.getTlfn() + "</td></tr>");
		}

		response.getWriter().append("</table></body></html>");
		

		
		
	}

}
