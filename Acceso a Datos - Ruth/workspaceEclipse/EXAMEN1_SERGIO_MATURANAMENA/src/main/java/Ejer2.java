

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Ejer2
 */
@WebServlet("/Ejer2")
public class Ejer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ejer2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession(true);
		int c = sesion.getAttribute("cont") != null? (int) sesion.getAttribute("cont") : 1;
		sesion.setAttribute("cont", c++);
		
		response.setContentType("text/plain");
		response.getWriter().append(request.getAttribute("cont").toString());
		
	}

}
