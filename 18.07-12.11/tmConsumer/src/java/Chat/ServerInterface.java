
package Chat;

/**
* <h1>ServerInterface</h1>
* Interface für Implementation des Servers
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;




public interface ServerInterface extends Remote {
    
    public boolean clientPruefenSenden (String name) throws RemoteException;
    public Map<String, ClientInterface> getClients() throws RemoteException;
    public ChatInterface subscribeUser(String username, ClientInterface handle) throws RemoteException;
    public boolean unsubscribeUser(String username) throws RemoteException;
    public boolean usernameVergeben (String eingabe) throws RemoteException;
    public ChatInterface getChat()throws RemoteException;
   
    
}
