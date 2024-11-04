package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejer3
 */
@WebServlet("/Ejer3")
public class Ejer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           ServletContext context = getServletContext();

           // Obtener el contador actual o inicializarlo a 1
           Integer count = (Integer) context.getAttribute("visitCount");
           if (count == null) {
               count = 1;
           } else {
               count++;
           }

           // Almacenar el nuevo valor del contador en el contexto
           context.setAttribute("visitCount", count);

           response.getWriter().println("<h1>Número total de visitas: " + count + "</h1>");
       }



}
