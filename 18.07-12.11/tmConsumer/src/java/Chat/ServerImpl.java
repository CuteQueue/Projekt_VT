/* 
    Author     : manuela & nina
*/
package Chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    ServerImpl() throws RemoteException {
        clients = new HashMap();
        System.out.println ("ServerImpl created...");
    }
    
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
    
    @Override
    public synchronized boolean usernameVergeben (String eingabe) throws RemoteException{
        if(clients.get(eingabe)!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public synchronized ChatInterface subscribeUser(String username, ClientInterface handle) throws RemoteException{
        clients.put(username, handle);
        return this.chat;
    }
    
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
