package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Ejemplo9
 */
@WebServlet("/Ejemplo9")
public class Ejemplo9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejemplo9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n = 1;
		boolean flag = false;
		response.setContentType("text/plain");
		
		//Recuperar el vector de cookies del navegadro
		Cookie[] cs = request.getCookies();
		if(cs!=null) {
			for (int i = 0; i < cs.length && !flag; i++) {
				if(cs[i].getName().equals("cont")) {
					n = Integer.parseInt(cs[i].getValue())+1;
					flag = true;
				}
			}
		}
		
		//Creo la cookie
		Cookie c = new Cookie("cont", String.valueOf(n));
		c.setMaxAge(60*60*24*365); //caduca en un año la cookie, se almacena en segundos
		//Enviar la cookie al navegador cliente en la respuesta del servidor
		response.addCookie(c);
		response.getWriter().append("Visitas regstradas: " + n);
		
	}

}
