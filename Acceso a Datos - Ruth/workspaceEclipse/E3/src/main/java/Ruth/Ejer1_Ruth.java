package Ruth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class Ejer1
 */
@WebServlet("/Ejer1")
public class Ejer1_Ruth extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public Ejer1_Ruth() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession sesion = request.getSession(true);
		int sumTotal;
		
		if(sesion.getAttribute("sum_total")!=null) {
			sumTotal = (Integer)sesion.getAttribute("sum_total");
		}else {
			sumTotal = 0;
		}
		
		Enumeration<String> parametros =  request.getParameterNames();
		while(parametros.hasMoreElements()) {
			String aux = (String)parametros.nextElement();
			response.getWriter().append(aux.equalsIgnoreCase("ticket") ? "TOTAL ACUMULADO: " + sumTotal + "<hr>" : aux);
			sumTotal+= aux.equalsIgnoreCase("ticket") ? 0 : Integer.parseInt(aux);
		}
		sesion.setAttribute("sum_total", sumTotal);
		
		response.getWriter().append("<html><body>")
							.append("<h1>Tienda Letras</h1>")
							.append("<form action='Ejer1' method='get'>")
							.append("<input type='submit' name='3' value='A'>")
							.append("<input type='submit' name='4' value='B'>")
							.append("<input type='submit' name='5' value='C'>")
							.append("<input type='submit' name='1' value='D'>")
							.append("<br>")
							.append("<input type='submit' name='ticket' value='ticket'>")
							.append("</form>")
							.append("</body></html>");
		
	}

}
