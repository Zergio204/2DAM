package listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * Application Lifecycle Listener implementation class SListener
 *
 */
@WebListener
public class SListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	se.getSession().setAttribute("datosSesion", "La sesion ID " + se.getSession().getId() + " ha sido creada" + new Date(se.getSession().getCreationTime()));
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
