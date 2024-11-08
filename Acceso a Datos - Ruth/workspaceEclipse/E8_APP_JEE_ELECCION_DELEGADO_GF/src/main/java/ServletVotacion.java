
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class ServletVotacion
 */
@WebServlet("/ServletVotacion")
public class ServletVotacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Integer> votos = new HashMap<>();
    private int contadorVotos = 0;
	
    /**
     * Default constructor. 
     */
    public ServletVotacion() {
        // TODO Auto-generated constructor stub
    	super();
        votos.put("Ruth Fernandez", 0);
        votos.put("Victor Vergel", 0);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String candidato = request.getParameter("candidato");
		votos.put(candidato, votos.get(candidato) + 1);
		contadorVotos++;
		response.getWriter().append("Voto registrado");
    }

}
