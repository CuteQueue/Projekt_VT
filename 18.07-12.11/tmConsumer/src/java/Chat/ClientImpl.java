
package Chat;

/**
* <h1>ClientImpl</h1>
* Client Implementation
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.List;


public class ClientImpl extends UnicastRemoteObject implements ClientInterface {
        
     String username = "";
     ServerInterface stub;
     private List <String> ausgaben;
      
    /**
    * main Methode der Klasse ClientImpl
    * @param args contains the command-line arguments as an array of String objects
    *@throws NotBoundException is thrown if an attempt is made to lookup or unbind in the registry a name that has no associated binding
    *@throws MalformedURLException Thrown to indicate that a malformed URL has occurred
    *@throws RemoteException communication-related exceptions that may occur during the execution of a remote method call
    */ 
      public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException  {
          
          String message = "";
          String nickname = "";
          
          Scanner sc = new Scanner(System.in);

            System.out.println("ChatServer: ");
            System.out.println("Bitte geben Sie einen Nutzernamen ein: ");
            
            String eingabe = sc.nextLine().trim();
            ClientInterface user = null;
            
            int login = 0;
            while(login == 0){

              try{
                  System.out.println("Bitte geben Sie eine ServerIP ein: ");
                  String serverIp = sc.nextLine().trim();
                  user = new ClientImpl(serverIp);
                  login = 1;
              }
              catch(Exception ex){
                  System.out.println("Fehler beim Serverlogin! Ungueltige ServerIP."); 
              }
            }
            
            while (user.getStub().usernameVergeben(eingabe)){
                System.out.println("Der Nickname " + eingabe + " ist bereits vergeben. \nBitte versuchen Sie es mit einem anderen Namen.");
                eingabe = sc.nextLine().trim();
            } 
            
            user.setUsername(eingabe);
            nickname = user.getUsername();
            
            System.out.println("Hallo " + nickname + ", willkommen im Chat!");
            System.out.println("----------------------------------------\n");
            ChatInterface chat = user.getStub().subscribeUser(user.getUsername(), user);
                    
            
            while(!message.equals("exit") ){
                System.out.print(">> ");
                message = sc.nextLine();
                chat.sendMessage(nickname, message);
            }
            message = "xX Logged Out Xx";
            chat.sendMessage(nickname, message);
            user.getStub().unsubscribeUser(nickname);
            System.out.println("Auf Wiedersehen " + nickname + "!" + "\nSie haben den Chat verlassen.\n");
            exit(0);
            
    }

    /**
    * Klassenkonstruktor ohne Parameter;
    * legt stub mit localhost als ServerIp an
    *@throws NotBoundException is thrown if an attempt is made to lookup or unbind in the registry a name that has no associated binding
    *@throws MalformedURLException Thrown to indicate that a malformed URL has occurred
    *@throws RemoteException communication-related exceptions that may occur during the execution of a remote method call
    */ 
    public ClientImpl()throws RemoteException, NotBoundException, MalformedURLException{
        stub = (ServerInterface) Naming.lookup ("rmi://localhost:1099/ChatServer");
        ausgaben = new ArrayList();
    }
    
    /**
    * Klassenkonstruktor;
    * legt stub mit mitgeteilter Ip als ServerIp an
    * @param ip ServerIP-Adresse
    *@throws NotBoundException is thrown if an attempt is made to lookup or unbind in the registry a name that has no associated binding
    *@throws MalformedURLException Thrown to indicate that a malformed URL has occurred
    *@throws RemoteException communication-related exceptions that may occur during the execution of a remote method call
    */ 
    public ClientImpl(String ip)throws RemoteException, NotBoundException, MalformedURLException{      
        stub = (ServerInterface) Naming.lookup ("rmi://" + ip + ":1099/ChatServer");
        ausgaben = new ArrayList();
    }
    
    /**
    * ruft ausgabeHinzu() auf und gibt auf der Konsole 
    * Username und Nachricht anderer Nutzer aus
    * @param username Name des Absenders
    * @param message Nachricht des Absenders
    *@throws RemoteException communication-related exceptions that may occur during the execution of a remote method call
    */  
    @Override
    public void receiveMessage(String username, String message) throws RemoteException{
       this.ausgabeHinzu(username + ": " +message);//Name des Users + seine Nachricht zur ausgaben-Liste hinzufügen
       if(!username.equals(this.username)){
           System.out.println("\n" + username + ": " + message); 
           System.out.print(">> ");
       } 
    }
      
      
    @Override
    public void setStub (ServerInterface stub){
        this.stub = stub;
    }

    @Override
    public ServerInterface getStub(){
        return this.stub;
    }

    @Override
    public void setUsername(String username) throws RemoteException {
        this.username = username;
    }
      
    @Override
    public String getUsername() throws RemoteException{
          return this.username;
      }
    
    /**
    * fügt String zu einer Liste von Chatausgaben hinzu
    * @param ausgabe Name des Absenders
    */ 
    @Override 
    public void ausgabeHinzu(String ausgabe)throws RemoteException{
        this.ausgaben.add(ausgabe);
    }
    
    @Override
    public List<String> getAusgaben() {
        return ausgaben;
    }


}
