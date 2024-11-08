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
import java.util.Iterator;

/**
 * Servlet implementation class Ejer3b
 */
@WebServlet("/Ejer3b")
public class Ejer3b_Ruth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer3b_Ruth() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HashMap<String, String> lib = getServletContext().getAttribute("libros")!=null?(HashMap<String, String>) getServletContext().getAttribute("libros"):new HashMap<String, String>();
		//Vector de cokies
		Cookie cs[]=request.getCookies();
		Double sum=0.0;
		if(cs!=null) {
			response.getWriter().append("<h1>Compra Total</h1><table border='1'><tr>")
								.append("<td>Titulo de libro: </td>")
								.append("<td>Unidades: </td>")
								.append("<td>Precio: </td></tr>");
			for (Cookie cookie : cs) {
				response.getWriter().append("<tr>")
									.append("<td>"+cookie.getName()+"</td>")
									.append("<td>"+cookie.getValue()+"</td>")
									.append("<td>"+lib.get(cookie.getName())+"</td></tr>");
				sum = sum + Double.parseDouble(cookie.getValue()) * Double.parseDouble(lib.get(cookie.getName()));
				//Borro la compra realizada
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
			response.getWriter().append("</table><br><h2>Total: " + sum + "</h2>");
			
		}else {
			response.getWriter().append("Usted no selecciono ningun libro");
		}
		
		
		
	}

}
