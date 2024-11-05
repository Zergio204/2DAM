package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Persona;

/**
 * Servlet implementation class Ej2
 */
@WebServlet("/Ej2")
public class Ej2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	ArrayList <Persona> listaPersonas=new ArrayList<Persona>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String nombre=request.getParameter("nombre");
		String apellidos=request.getParameter("apellidos");
		String edad=request.getParameter("edad");
		String contacto=request.getParameter("contacto");
		
		Persona p=new Persona(nombre,apellidos,edad,contacto);
		listaPersonas.add(p);
		
		for (Persona person : listaPersonas) {
			response.getWriter().append("Nombre: " + person.getNombre() + "<br>");
			response.getWriter().append("Apellidos: " + person.getApellidos() + "<br>");
			response.getWriter().append("Edad: " + person.getEdad() + "<br>");
			response.getWriter().append("Contacto: " + person.getContacto() + "<br>");
		}
		
		
	}


}
