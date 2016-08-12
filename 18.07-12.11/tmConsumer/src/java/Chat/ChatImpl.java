/* 
    Author     : manuela & nina
*/

package Chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Set;



public class ChatImpl extends UnicastRemoteObject implements ChatInterface{
    ServerInterface stub;
     
    /**
     * @param args the command line arguments
     */
    
    public ChatImpl()throws RemoteException, NotBoundException, MalformedURLException{
        stub = (ServerInterface) Naming.lookup ("rmi://localhost:1099/ChatServer");
    }
    
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
