

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Servlet implementation class Ejercicio1
 */
@WebServlet("/Ejercicio1")
public class Ejercicio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> tareas;
    private String fichero = "tareas.ser";

    /**
     * Default constructor. 
     */
    public Ejercicio1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public void init() throws ServletException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            tareas = (HashMap<String, String>) ois.readObject();
        } catch (Exception e) {
            tareas = new HashMap<>();
        }
        getServletContext().setAttribute("notificaciones", tareas);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idTarea = request.getParameter("idTarea");
        String descripcion = request.getParameter("descripcion");

        if (idTarea != null && descripcion != null) {
            tareas.put(idTarea, descripcion);
        }

        response.setContentType("text/html");
        response.getWriter().append("<html><body>")
        					.append("<h1>Tareas</h1>");
        for (String key : tareas.keySet()) {
        	response.getWriter().append("<p>" + key + ": " + tareas.get(key) + "</p>");
        }
        response.getWriter().append("</body></html>");
	}
	
	
	public void destroy() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(tareas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}