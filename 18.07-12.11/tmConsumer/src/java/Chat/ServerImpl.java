package Chat;

/**
* <h1>ServerImpl</h1>
* Server-Implementation
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.HashMap;


public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    private ChatInterface chat;
    private Map <String, ClientInterface> clients;
    
    /**
    * main Methode der Klasse ServerImpl
    * 
    * @param args contains the supplied command-line arguments as an array of String objects
    */ 
    public static void main(String[] args) {

        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry (Registry.REGISTRY_PORT);
            registry = LocateRegistry.getRegistry();
            
           
        } catch (RemoteException rex) {
            System.err.println ("RemoteException occured: " +  rex);           
        }
        if (registry == null) {
           System.err.println ("Cannot find registry");
           System.exit(0);
        }
        
        try {
            // Objekt anlegen und Export v. Serverobjekt
            ServerImpl obj = new ServerImpl();
     
            // Stub registrieren
            registry.rebind ("ChatServer", obj);
            System.out.println ("ServerImpl registered as 'ChatServer' ...");
            obj.chat = new ChatImpl();
        } catch (java.rmi.ConnectException cex) {
            System.err.println ("ConnectException while accessing registry (port = " + Registry.REGISTRY_PORT + ")");
            System.err.println ("Run 'rmiregistry " + Registry.REGISTRY_PORT + "'");
            System.exit(0);
        } catch (Exception ex) {
            System.err.println ("Exception during server registration (registry port = " + Registry.REGISTRY_PORT + ")");
            ex.printStackTrace();
            System.exit(0);
        }
    }
    
    /**
    * Klassenkonstruktor ServerImpl;
    * legt HashMap für Clients an.
    */ 
    ServerImpl() throws RemoteException {
        clients = new HashMap();
        System.out.println ("ServerImpl created...");
    }
    
    /**
    * prüft, ob Client noch im Chat aktiv, sonst wird er aus der HashMap entfernt.
    * @param name Name des zu prüfenden Clients
    * @return boolschen Wert mit Angabe, ob client NAchricht empfangen kann oder nicht
    */ 
    @Override
    public synchronized boolean clientPruefenSenden (String name) throws RemoteException{
        
        try{
            System.out.println("Aktueller Key: " + name);
            clients.get(name).getUsername();
            return true;
        }
        catch (RemoteException rex){
           System.out.println(name + " hat Chat verlassen.");
           unsubscribeUser(name);                 
           return false;               
      } 
    }
    
    /**
    * prüft, ob der Name im Chat bereits vergeben ist
    * @param eingabe eingegebener Username
    * @return boolschen Wert mit Angabe, ob Username bereits vergeben
    */ 
    @Override
    public synchronized boolean usernameVergeben (String eingabe) throws RemoteException{
        if(clients.get(eingabe)!=null){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
    * Client wird in die HashMap der im Chat aktiven Clients zugefügt
    * @param username Name des Users
    * @param handle Clientinterface
    * @return ChatImpl mit sendMessage Methode
    */ 
    @Override
    public synchronized ChatInterface subscribeUser(String username, ClientInterface handle) throws RemoteException{
        clients.put(username, handle);
        return this.chat;
    }
    
    /**
    * Client wird aus der HashMap der Clients entfernt
    * @param username Name des Users
    * @return boolschen Wert, ob User entfernt wurde
    */
    @Override
    public synchronized boolean unsubscribeUser(String username) throws RemoteException{
        if (clients.containsKey(username)){
            clients.remove(username);
            return true;
        }
        return false;
    }
    
    @Override
    public synchronized Map getClients(){
        return clients;
    }
     
    @Override
    public ChatInterface getChat() {
        return chat;
    }

}
