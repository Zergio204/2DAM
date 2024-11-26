package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clases.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init() throws ServletException {
		super.init();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Lista usuarios registrados almacenada en contexto
		List<Usuario> usuariosReg = getServletContext().getAttribute("usersReg") != null 
				? (List<Usuario>) getServletContext().getAttribute("usersReg") : new ArrayList<Usuario>();
		
		String page="";
		
		switch (request.getParameter("boton")) {
		case "Registro":
			String nombre = request.getParameter("nombre");
			String pass = request.getParameter("contrasena");
			String cat = request.getParameter("categoria");
			if(!nombre.isBlank() && !pass.isBlank()) {
				//Invalido sesion si hubiera
				request.getSession(true).invalidate();
				//Creo una nueva sesion
				HttpSession session = request.getSession(true);
				Usuario user = new Usuario(nombre, pass, cat);
				//Guardo el usuario en la sesion
				session.setAttribute("usuario", user);
				//Guardo en la lista el usuario
				usuariosReg.add(user);
				//Actualizo la lista en el contexto
				getServletContext().setAttribute("usersReg", usuariosReg);
				page = "Acceso.jsp";
			}else {
				request.setAttribute("sinDatos", true);
				page = "Registro.jsp";
			}
			break;
		case "Acceso":
			page = "Aplicacion.jsp";
			break;
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

}
