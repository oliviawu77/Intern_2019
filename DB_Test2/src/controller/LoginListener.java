package controller;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class myLoginListener
 *
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener {
	
	 private static int tSessions;
	    public static int GetSessions() {
	        return LoginListener.tSessions;
	      }
	    
    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
        // TODO Auto-generated method stub
   	tSessions++;
   }
	/**
    * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
    */
   public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
        // TODO Auto-generated method stub
   	tSessions--;
   }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
