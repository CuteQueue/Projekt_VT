/* 
    Author     : manuela & nina
*/

package Chat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ChatInterface extends Remote {
    
    public void sendMessage(String username, String message) throws RemoteException;
}
