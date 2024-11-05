package Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Ej1
 */
@WebServlet("/Ej1")
public class Ej1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ej1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
        String producto = request.getParameter("producto");
        double total = session.getAttribute("total") != null ? (Double) session.getAttribute("total") : 0.0;

        if (producto.equals("A (3€)")) {
            total += 3;
        } else if (producto.equals("B (4€)")) {
            total += 4;
        } else if (producto.equals("C (5€)")) {
            total += 5;
        } else if (producto.equals("D (1€)")) {
            total += 1;
        }

        response.setContentType("text/html");

        if (producto.equals("Ticket")) {
        	response.getWriter().append("<html><body>");
        	response.getWriter().append("<h2>Total de la compra: " + total + "€</h2>");
            session.invalidate(); // Limpiar la sesión
            response.getWriter().append("<a href='html1.html'>Volver a la página de compra</a>");
            response.getWriter().append("</body></html>");
        } else {
            session.setAttribute("total", total);
            response.sendRedirect("html1.html"); // Redirigir al HTML
        }

	}

}
