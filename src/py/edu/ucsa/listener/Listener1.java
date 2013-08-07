package py.edu.ucsa.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Listener1
 *
 */
@WebListener
public class Listener1 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Listener1() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Iniciando" + event.getServletContext().getServletContextName());
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Finalizando" + event.getServletContext().getServletContextName());
    }
	
}
