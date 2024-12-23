package servlets;

import java.util.Date;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class ListenerSesion
 *
 */
@WebListener
public class ListenerSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public ListenerSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession sesion = se.getSession();
    	System.out.println("A las " + new Date(System.currentTimeMillis()).toString() + " se ha creado una sesion con id: " + sesion.getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	HttpSession sesion = se.getSession();
    	System.out.println("A las " + new Date(System.currentTimeMillis()).toString() + " se eliminó una sesion con id: " + sesion.getId());
    }
	
}
