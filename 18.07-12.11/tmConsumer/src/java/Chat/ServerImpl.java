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
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class ServerImpl extends UnicastRemoteObject implements ServerInterface {
    private ChatInterface chat;
    private Map <String, ClientInterface> clients;
    
    
    public static void main(String[] args) {
        // Man kann entweder eine lokale Registry erzeugen ...
        // LocateRegistry.createRegistry (Registry.REGISTRY_PORT);
        // ... oder verwendet die Standard-RMI Registry als externer
        // Prozess auf dem lokalen Host unter Port 1099. 
        // In diesem Fall wird mit getRegistry() auf diese zugegriffen.
        // Bei Verwendung der externen Registry kann es zu einer ClassNotException kommen, 
        // wenn rmiregistry keinen Zugriff auf die Stud-Klasse TimeServer hat.
        // 'rmiregistry 1099' sollte also im Verzeichnis build/classes aufgerufen 
        // werden (alternativ kann auch der Classpath angepasst werden).
        //
        // Die Konfiguration von Policies wird in der Datei 
        // timer.policy gezeigt.

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
            // Objekt anlegen und exportieren des Server-Objektes
            ServerImpl obj = new ServerImpl();
     
            //ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(obj, 0);
            // Stub registrieren
            registry.rebind ("ChatServer", obj);
            // Es gibt auch eine statische Methode, die verwendet werden kann.
            // Naming.rebind ("TimeServer", new TimeServerImpl());
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
        // Ctor emittiert ggf. RemoteException
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
