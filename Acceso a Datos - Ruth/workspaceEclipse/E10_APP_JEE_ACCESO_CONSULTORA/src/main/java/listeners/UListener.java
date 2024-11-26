package listeners;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UListener
 *
 */
@WebListener
public class UListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public UListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	Map<String, String> mapaCategorias = new HashMap<String, String>();
    	mapaCategorias.put("C1A","Programador Senior");
    	mapaCategorias.put("C1B","Programador Junior");
    	mapaCategorias.put("C2A","Analista");
    	mapaCategorias.put("C2B","Analista-Programador");
    	mapaCategorias.put("C3","Jefe de Proyecto");
    	sce.getServletContext().setAttribute("mapaCategoria", mapaCategorias);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
