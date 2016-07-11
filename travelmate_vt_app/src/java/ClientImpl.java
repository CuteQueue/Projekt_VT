/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
      
      
      public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException  {
          
          String message = "";
          String nickname = "";
          
          Scanner sc = new Scanner(System.in);

            // Zwei Moeglichkeiten, auf die Registry zuzugreifen:
            // 1. Option: Referenz auf Registry bestimmen und darauf lookup()
            // durchführen.
            // Registry registry = LocateRegistry.getRegistry();
            // TimeServer timer = (TimeServer) registry.lookup("TimeServer");
            // 2. Option: Per URL direkt auf registriertes Interface zugreifen.
            
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

      
      public ClientImpl()throws RemoteException, NotBoundException, MalformedURLException{
          stub = (ServerInterface) Naming.lookup ("rmi://localhost:1099/ChatServer");
           ausgaben = new ArrayList();
      }
      
      public ClientImpl(String ip)throws RemoteException, NotBoundException, MalformedURLException{      
          stub = (ServerInterface) Naming.lookup ("rmi://" + ip + ":1099/ChatServer");
           ausgaben = new ArrayList();
      }
      
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
      
      @Override 
    public void ausgabeHinzu(String ausgabe)throws RemoteException{
        this.ausgaben.add(ausgabe);
    }
    
        @Override
    public List<String> getAusgaben() {
        return ausgaben;
    }


}
