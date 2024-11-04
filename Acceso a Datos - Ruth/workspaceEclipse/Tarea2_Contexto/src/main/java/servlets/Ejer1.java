	package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejer1
 */
@WebServlet("/Ejer1")
public class Ejer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String pColor="";
	private String color2="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		pColor=config.getServletContext().getInitParameter("color");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		color2 = request.getParameter("color") != null ? request.getParameter("color") : pColor;
		
//		if (request.getParameter("color") != null) {
//			color2 = request.getParameter("color");
//		} else {
//			color2 = pColor;
//		}
		
		//Lo guardo como atributo, no como parrametro
		getServletContext().setAttribute("color", color2);
		
		response.getWriter().append("<html><head></head><body style='background-color:" + color2 + "'>"
				+ "<form action='Ejer1b' method='post'>"
				+ "<input type='submit' value='boton'>"
				+ "<input type='hidden' name='nuevoColor' value='" + getServletContext().getAttribute("color") + "'>"
				+ "</form></body></html>");
		
		
	}

}
