package Ruth;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Ejer3
 */
@WebServlet("/Ejer3")
public class Ejer3_Ruth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Map<String,String> lib = new HashMap<String,String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer3_Ruth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		lib.put("Java", "67.00");
		lib.put("C", "56.00");
		lib.put("C++", "63.00");
		lib.put("VB", "52.00");
		lib.put("Phyton", "46.00");
		config.getServletContext().setAttribute("libros", lib);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<h1>bienvenido a la librería. Selecciones un libro.</h1><br>")
							.append("<form action='Ejer3' method='post'>")
							.append("<h3>Listado de libros")
							.append("<select name'list'>");
						lib.forEach((k,v)->{
							try {
								response.getWriter().append("<option>"+k+"</option>");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						});
		response.getWriter().append("</select>").append("Unidades: <input type='text' name='ud' value='0'/>")
												.append("<input type='submit' name='enviar' value='Enviar'")
												.append("</h3></form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!request.getParameter("ud").equals("0")) {
			//Crear cookie con las unidades seleccionadas por el usuaroio
			Cookie c = new Cookie(request.getParameter("list"),request.getParameter("ud"));
			//Añadir la cookie al servidor
			response.addCookie(c);
			response.getWriter().append("<h1>Bienbenidos. Ha seleccionado " + request.getParameter("list"));
		}else {
			response.getWriter().append("<h1>No ha seleccionado ningun libro</h1>");
		}
		
		response.getWriter().append("<a href='Ejer3'>Sigue comprando</a>")
							.append("<a href='Ejer3b'>Ver Compra</a>");
		
	}

}
