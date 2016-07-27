package Chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface ClientInterface extends Remote {
    
    public void receiveMessage(String username, String message) throws RemoteException;
    //public boolean clientVorhanden () throws RemoteException;
    
    public void setUsername(String username) throws RemoteException ;
    public String getUsername() throws RemoteException ;

    
    public void setStub (ServerInterface stub) throws RemoteException;
    public ServerInterface getStub() throws RemoteException ;
    
     public List<String> getAusgaben() throws RemoteException;
     public void ausgabeHinzu(String ausgabe)throws RemoteException;
    /*public String getIpServer();
    public void setIpServer(String IpServer);*/
}
