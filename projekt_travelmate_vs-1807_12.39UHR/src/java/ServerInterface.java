/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;



public interface ServerInterface extends Remote {
    
    public boolean clientPruefenSenden (String name) throws RemoteException;
    public Map<String, ClientInterface> getClients() throws RemoteException;
    public ChatInterface subscribeUser(String username, ClientInterface handle) throws RemoteException;
    public boolean unsubscribeUser(String username) throws RemoteException;
    public boolean usernameVergeben (String eingabe) throws RemoteException;
    public ChatInterface getChat()throws RemoteException;
   
    
}
