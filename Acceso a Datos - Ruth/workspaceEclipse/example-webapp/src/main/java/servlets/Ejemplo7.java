package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo7
 */
@WebServlet("/Ejemplo7")
public class Ejemplo7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String paramContext="";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		//No podemos crear o modificar parametros de inicialización
		//Una vez arrancado el contexto
		//config.getServletContext().setInitParameter("paramContext", "paramContext");
		//Recupero el parammetro de inicialización
		paramContext=config.getServletContext().getInitParameter("prueba");
		config.getServletContext().setAttribute("attribContext", "ATRIBUTO DE DAMMM");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Parametro de inicializacion del contexto: " + paramContext);
		response.getWriter().append("Atributo del contexto: " + getServletContext().getAttribute("attribContext"));
		
	}

}