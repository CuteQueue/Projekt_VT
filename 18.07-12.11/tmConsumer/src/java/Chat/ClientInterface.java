
package Chat;

/**
* <h1>ClientInterface</h1>
* Interface für Implementation der Clients
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface ClientInterface extends Remote {
    
    public void receiveMessage(String username, String message) throws RemoteException;
    
    public void setUsername(String username) throws RemoteException ;
    public String getUsername() throws RemoteException ;

    
    public void setStub (ServerInterface stub) throws RemoteException;
    public ServerInterface getStub() throws RemoteException ;
    
    public List<String> getAusgaben() throws RemoteException;
    public void ausgabeHinzu(String ausgabe)throws RemoteException;

}
