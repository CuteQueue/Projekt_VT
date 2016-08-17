

package Chat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Set;

/**
* <h1>ChatImpl</h1>
* kümmert sich um die Nachrichtenverteilung an alle Clients
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

public class ChatImpl extends UnicastRemoteObject implements ChatInterface{
    ServerInterface stub;
     
    /**
     * Klassenkonstruktor
     * 
     *@throws NotBoundException is thrown if an attempt is made to lookup or unbind in the registry a name that has no associated binding
     *@throws MalformedURLException Thrown to indicate that a malformed URL has occurred
     *@throws RemoteException communication-related exceptions that may occur during the execution of a remote method call
    */ 
     
    public ChatImpl()throws RemoteException, NotBoundException, MalformedURLException{
        stub = (ServerInterface) Naming.lookup ("rmi://localhost:1099/ChatServer");
    }
    
    
   /**
   * prüft an welche Clients eine Nachricht geschickt werden 
   * kann und informiert diese, neue Nachricht zu empfangen
   * @param username  User, der Nachricht geschrieben hat
   * @param message  zu übermittelnde Nachricht
    *@throws RemoteException communication-related exceptions that may occur during the execution of a remote method call
    */ 
   
    @Override
    public synchronized void sendMessage(String username, String message) throws RemoteException{
        Map <String, ClientInterface > clients = stub.getClients();
            
        Set<String> names = clients.keySet();
          for(String name : names){
              if(stub.clientPruefenSenden(name)){
                
                System.out.println("Nachricht kann gesendet werden an " + name);
            }
            else{
                System.out.println("Nachricht konnte nicht an " +name+ " gesendet werden.");
            }
          }
          clients = stub.getClients();
          for(ClientInterface client: clients.values()) {
            client.receiveMessage(username, message);
          }
    }
    
    
}
