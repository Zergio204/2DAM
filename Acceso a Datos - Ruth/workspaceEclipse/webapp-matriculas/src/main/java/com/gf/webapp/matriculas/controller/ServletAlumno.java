package com.gf.webapp.matriculas.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.gf.webapp.matriculas.entities.Alumno;
import com.gf.webapp.matriculas.ln.AlumnoLN;

/**
 * Servlet implementation class ServletAlumno
 */
@WebServlet("/ServletAlumno")
public class ServletAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String page="";
		switch(request.getParameter("boton")) {
			case "Alta":
				page = "AltaAlumno.jsp";
				break;
			case "Baja":
				page = "BajaAlumno.jsp";
				break;
			case "Actualiza":
				page = "ActualizaAlumno.jsp";
				break;
			case "Consulta":
				page = "ConsultaAlumno.jsp";
				break;
			default:
				break;
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean error = false;
		String msj = "";
		String page = "";
		
		//Recogida de parametros
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String curso = request.getParameter("curso");
		String ciclo = request.getParameter("ciclo");
		//Creacion del objeto alumno
		Alumno a = new Alumno(nombre, apellidos, curso, ciclo);
		
		try {
			switch (request.getParameter("boton")) {
				case "Alta": {
					//Llamada a la LN
					msj = AlumnoLN.alta(a);
					break;
				}
				case "Baja": {
					
					break;
				}
				case "Consulta": {
					
					break;
				}
				case "Actualiza": {
					
					break;
				}
				default:
					break;
			}
		} catch (Exception e) {
			error = true;
            System.out.println("ServletAlumno: Se ha producido el siguiente error");
            e.printStackTrace();
        }finally {
			if ("Volver".equals(request.getParameter("boton"))) {
				page = "Menu.jsp";
			}else {
				if(error) {
					msj = "Error al realizar la transaccion.";
				}
				request.setAttribute("mensaje", msj);
				page = "Mensaje.jsp";
			}
			
			request.getRequestDispatcher(page).forward(request, response);
		}
		
		
	}

}
