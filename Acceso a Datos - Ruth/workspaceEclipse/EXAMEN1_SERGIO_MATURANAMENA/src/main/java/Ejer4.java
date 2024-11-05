

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejer4
 */
@WebServlet("/Ejer4")
public class Ejer4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String deportes = request.getParameter("Deportes") == null ? null : "Deportes";
		String moda = request.getParameter("Moda") == null ? null : "Moda";
		String gastronomia = request.getParameter("Gastronomia") == null ? null : "Gastronomia";
		String turismo = request.getParameter("Turismo") == null ? null : "Turismo";
		
		if(deportes != null) {
			Cookie c1 = new Cookie("Deportes", deportes);
			c1.setMaxAge(60);
			response.addCookie(c1);
		}
		
		if(moda != null) {
			Cookie c2 = new Cookie("Moda", moda);
			c2.setMaxAge(60);
			response.addCookie(c2);
		}
		
		if(gastronomia != null) {
			Cookie c3 = new Cookie("Gastronomia", gastronomia);
			c3.setMaxAge(60);
			response.addCookie(c3);
		}

		if(turismo != null) {
			Cookie c4 = new Cookie("Turismo", turismo);
			c4.setMaxAge(60);
			response.addCookie(c4);
		}
		
		Cookie[] cs = request.getCookies();
		
		response.setContentType("text/html");
		response.getWriter().append("<html><body>")
							.append("<h1>NEWSLETTER</h1><h2>Las noticias de hoy para usted!</h2>")
							.append("<ul>");
							for (int i = 0; i < cs.length; i++) {
								response.getWriter().append("<li>Noticia " + cs[i].toString() + "</li>");
							}
		response.getWriter().append("</ul>")
							.append("</body></html>");
		
	}

}
