/**
* <h1>ChatInterface</h1>
* Interface für Implementation der Nachrichtenverteilung
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

package Chat;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatInterface extends Remote {
   
    public void sendMessage(String username, String message) throws RemoteException;
}
