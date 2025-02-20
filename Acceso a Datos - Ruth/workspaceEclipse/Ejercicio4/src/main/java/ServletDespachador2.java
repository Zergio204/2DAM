

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletDespachador2
 */
@WebServlet("/ServletDespachador2")
public class ServletDespachador2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDespachador2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String color = request.getParameter("color");
		String numero = request.getParameter("numero");
		
		RequestDispatcher despachadorBienvenida = request.getRequestDispatcher("ServletBienvenida2");
		RequestDispatcher despachadorError = request.getRequestDispatcher("Error2");
		
		if(numero.isBlank()) {
			despachadorError.forward(request, response);
		}else {
			despachadorBienvenida.forward(request, response);
		}
		
	}

}
