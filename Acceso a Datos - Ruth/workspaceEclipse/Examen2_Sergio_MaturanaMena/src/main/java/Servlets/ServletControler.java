package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Clases.Producto;

/**
 * Servlet implementation class ServletControler
 */
@WebServlet("/ServletControler")
public class ServletControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("001", "Camiseta", 15.0));
        productos.add(new Producto("002", "Gorra", 10.0));
        productos.add(new Producto("003", "Mochila", 25.0));
        getServletContext().setAttribute("productos", productos);
        getServletContext().setAttribute("dailyPurchases", 0); // Contador inicial
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

        if ("viewCart".equals(action)) {
            // Redirigir internamente a la página del carrito
            RequestDispatcher dispatcher = request.getRequestDispatcher("compra.jsp");
            dispatcher.forward(request, response);
        } else if ("login".equals(action)) {
            // Redirigir internamente a la página de acceso (login)
            RequestDispatcher dispatcher = request.getRequestDispatcher("acceso.jsp");
            dispatcher.forward(request, response);
        } else if ("logout".equals(action)) {
            // Manejar el cierre de sesión
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            // Redirigir internamente al índice después de cerrar sesión
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");

        if ("addToCart".equals(action)) {
            HttpSession session = request.getSession();
            List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");
            if (carrito == null) {
                carrito = new ArrayList<>();
            }

            String ref = request.getParameter("productRef");
            List<Producto> productos = (List<Producto>) getServletContext().getAttribute("productos");

            for (Producto producto : productos) {
                if (producto.getRef().equals(ref)) {
                    carrito.add(producto);
                    break;
                }
            }
            session.setAttribute("carrito", carrito);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } else if ("checkout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.removeAttribute("carrito");
            }

            synchronized (this) {
                int dailyPurchases = (int) getServletContext().getAttribute("dailyPurchases");
                getServletContext().setAttribute("dailyPurchases", dailyPurchases + 1);
            }


            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if ("admin".equals(username) && "admin".equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("role", "admin");

                RequestDispatcher dispatcher = request.getRequestDispatcher("mantenimiento.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", "Credenciales incorrectas");

                RequestDispatcher dispatcher = request.getRequestDispatcher("acceso.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}