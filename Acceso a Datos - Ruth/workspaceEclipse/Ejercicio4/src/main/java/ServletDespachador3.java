

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletDespachador3
 */
@WebServlet("/ServletDespachador3")
public class ServletDespachador3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDespachador3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher despachadorBienvenida = request.getRequestDispatcher("ServletBienvenida3");
		RequestDispatcher despachadorError = request.getRequestDispatcher("ServletError3");
		
		if(request.getParameter("texto").isBlank()) {
			despachadorError.forward(request, response);
		}else {
			despachadorBienvenida.forward(request, response);
		}
		
	}

}
