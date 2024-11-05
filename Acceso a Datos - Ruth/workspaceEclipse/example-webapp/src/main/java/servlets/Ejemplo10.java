package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo10
 */
@WebServlet("/Ejemplo10")
public class Ejemplo10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletContext sc;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo10() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		sc=config.getServletContext();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<html><body>")
							.append("<form action='Ejemplo10' method='post'")
							.append("<h1>PROBANDO DESPACHADOR</h1>")
							.append("<input type='submit' name='metodo' value='include'/>")
							.append("<input type='submit' name='metodo' value='forward'/>")
							.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("<html>")
							.append("<body style='background-color:#AAFF9F'>")
							.append("<h3>Ejemplo de RequestDispatcher</h3>")
							.append("<p>Este servlet usa un despachador que nos lleva a un servlet despachador</p>");
		//Rutas absolutas, no permite relativas
		//RequestDispatcher dispatcher = sc.getRequestDispatcher("Ejemplo10b");
		RequestDispatcher dispatcher = request.getRequestDispatcher("Ejemplo10b");
		if(dispatcher!=null) {
			request.setAttribute("AttribDispatcher", "Llega atributo");
			if(request.getParameter("metodo").equalsIgnoreCase("include")) {
				dispatcher.include(request, response);
			}else { //forward
				dispatcher.forward(request, response);
			}
			response.getWriter().append("<p>Vuelta del servlet despachador</p>");
		}else {
			response.getWriter().append("No se encontro el despachador");
		}
		response.getWriter().append("</body></html>");
	}

}
