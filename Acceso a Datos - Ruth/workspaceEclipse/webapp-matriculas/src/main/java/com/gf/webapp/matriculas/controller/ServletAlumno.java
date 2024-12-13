package com.gf.webapp.matriculas.controller;

import java.io.IOException;

import com.gf.webapp.matriculas.entities.Alumno;
import com.gf.webapp.matriculas.ln.AlumnoLN;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "";
        switch (request.getParameter("boton")) {
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
        case "Menu":
            page = "Menu.jsp";
            break;
        default:
            page = "Menu.jsp";
            break;
        }
		request.getRequestDispatcher(page).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean error = false;
		String msj = "";
		String page = "";

		// Recogida de parámetros
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String ciclo = request.getParameter("ciclo");
		String curso = request.getParameter("curso");
		// Creación del objeto alumno
        Alumno a = new Alumno(nombre, apellidos, curso, ciclo);
        try {
            switch (request.getParameter("boton")) {
            case "Alta":
                msj = AlumnoLN.alta(a);
                break;
            case "Baja":
                msj = AlumnoLN.baja(a);
                break;
            case "Actualiza":
                msj = AlumnoLN.actualiza(a);
                break;
            case "Consulta":
                msj = AlumnoLN.consulta(a);
                break;
            case "Volver":
                page = "Menu.jsp";
                break;
            default:
                break;
            }
        } catch (Exception e) {
            error = true;
            System.out.println("ServletAlumno: Se ha producido el siguiente error");
            e.printStackTrace();
            msj = "Error al realizar la transacción: " + e.getMessage();
        } finally {
            if (!"Volver".equals(request.getParameter("boton"))) {
                request.setAttribute("mensaje", msj);
                page = "Mensaje.jsp";
            }
            request.getRequestDispatcher(page).forward(request, response);
        }

	}

}
