package paquete;

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
    private static final int MAX_VOTOS = 5;
    private int contadorVotos = 0;
    private Map<String, Votacion> candidatos = new HashMap<>();
    
    /**
     * Default constructor. 
     */
    public void init() {
        candidatos.put("Ruth Fernández", new Votacion("Ruth Fernández"));
        candidatos.put("Víctor Vergel", new Votacion("Víctor Vergel"));
        candidatos.put("BLANCO", new Votacion("BLANCO")); 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String[] seleccionados = request.getParameterValues("candidato");
        if (seleccionados == null || seleccionados.length == 0) {
            Votacion votoBlanco = candidatos.get("BLANCO");
            if (votoBlanco != null) {
                votoBlanco.incrementarVotos();
            }
        } else {
            for (String nombre : seleccionados) {
                Votacion votacion = candidatos.get(nombre);
                if (votacion != null) {
                    votacion.incrementarVotos();
                }
            }
        }
        contadorVotos++;
        if (contadorVotos >= MAX_VOTOS) {
            contadorVotos = 0;
            for (Votacion votacion : candidatos.values()) {
                votacion.resetVotos();
            }
        }
        request.setAttribute("resultados", candidatos);
        request.getRequestDispatcher("Resultados.jsp").forward(request, response);
    }

}
