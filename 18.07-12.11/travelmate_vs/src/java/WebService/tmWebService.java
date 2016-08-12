/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;
import static sun.security.krb5.Confounder.bytes;
import tm.Message;
import tm.User;

/**
 *
 * @author nina
 */
@WebService(serviceName = "tmWebService")
public class tmWebService {

    @Resource(name = "travelmate_vs")
    private DataSource travelmate_vs;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "email") String email, @WebParam(name = "pw") String pw) {
        try {

            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?"); //where id = ?

            pstmt.setString(1, email);
            pstmt.setString(2, pw);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            String text = rs.getString("name");
            rs.close();
            con.close();
            
            return text;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getSalt")
    public byte[] getSalt(@WebParam(name = "email") String email) {
        try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ?"); //where id = ?

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            //String text = "butz";
            byte[] salt = rs.getBytes("salt");
            rs.close();
            con.close();
            return salt;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getEncryptedPw")
    public byte[] getEncryptedPw(@WebParam(name = "email") String email) {
        try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ?"); //where id = ?

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            byte[] encryptedPw = rs.getBytes("password");
            rs.close();
            con.close();
            return encryptedPw;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "newUser")
    public String newUser(@WebParam(name = "name") String name, @WebParam(name = "last_name") String last_name, @WebParam(name = "nickname") String nickname, @WebParam(name = "email") String email, @WebParam(name = "salt") byte[] salt, @WebParam(name = "password") byte[] password) {
        try {

            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (name, last_name, nickname, email, salt, password) VALUES (?,?,?,?,?,?)"); //where id = ?
            pstmt.executeQuery("SET NAMES UTF8");
            pstmt.executeQuery("SET CHARACTER SET UTF8");
            pstmt.setString(1, name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, nickname);
            pstmt.setString(4, email);
            pstmt.setBytes(5, salt);
            pstmt.setBytes(6, password);
            pstmt.executeUpdate();
            con.close();
            String answer = "Added!";
            return answer;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createProfile")
    public String createProfile(@WebParam(name = "id") int id, @WebParam(name = "mobilenumber") String mobilenumber, @WebParam(name = "age") int age, @WebParam(name = "location") String location, @WebParam(name = "sex") String sex, @WebParam(name = "destination") String destination, @WebParam(name = "startdate") String startdate, @WebParam(name = "interests") String interests, @WebParam(name = "looking_for") String looking_for, @WebParam(name = "about") String about) {
        try {
            
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO profils (user_id, mobilenumber, age, location, sex, destination, startdate, interests, looking_for, about) VALUES (?,?,?,?,?,?,?,?,?,?)"); //where id = ?
            pstmt.executeQuery("SET NAMES UTF8");
            pstmt.executeQuery("SET CHARACTER SET UTF8");
            pstmt.setInt(1, id);
            pstmt.setString(2, mobilenumber);
            pstmt.setInt(3, age);
            pstmt.setString(4, location);
            pstmt.setString(5, sex);
            pstmt.setString(6, destination);
            pstmt.setString(7, startdate);
            pstmt.setString(8, interests);
            pstmt.setString(9, looking_for);
            pstmt.setString(10, about);
            pstmt.executeUpdate();
            //rs.next();
            //byte[] encryptedPw = rs.getBytes("password");
            //rs.close();
            con.close();
            return "ok";
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "error";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editProfile")
    public String editProfile(@WebParam(name = "id") int id, @WebParam(name = "mobilenumber") String mobilenumber, @WebParam(name = "age") int age, @WebParam(name = "location") String location, @WebParam(name = "sex") String sex, @WebParam(name = "destination") String destination, @WebParam(name = "startdate") String startdate, @WebParam(name = "interests") String interests, @WebParam(name = "looking_for") String looking_for, @WebParam(name = "about") String about) {
        try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("UPDATE profils SET mobilenumber = ?, age = ?, location = ?, sex = ?, destination = ?, startdate = ?, interests = ?, looking_for = ?, about = ? WHERE user_id = ?"); 
            pstmt.executeQuery("SET NAMES UTF8");
            pstmt.executeQuery("SET CHARACTER SET UTF8");
            pstmt.setString(1, mobilenumber);
            pstmt.setInt(2, age);
            pstmt.setString(3, location);
            pstmt.setString(4, sex);
            pstmt.setString(5, destination);
            pstmt.setString(6, startdate);
            pstmt.setString(7, interests);
            pstmt.setString(8, looking_for);
            pstmt.setString(9, about);
            pstmt.setInt(10, id);
            int update = pstmt.executeUpdate();
           
            con.close();

            if (update == 1) {
                System.out.println("Profile is updated!");
            } else {
                System.out.println("Error! Could not update profile");
            }
            return "ok";
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "error";
        }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findTravelmates")
    public List<User> findTravelmates(@WebParam(name = "destination") String destination, @WebParam(name = "gender") String gender) {
        try {
            //Es werden alle User in der Datenbank gesucht, die den Kriterien entsprechen (Reiseziel, Geschlecht)
            //diese werden dann in einer Liste gespeichert und zurückgegeben

            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = null;
            List<User> travelmates = new ArrayList();

            if (gender.equals("both")) {
            //Wenn das Geschlecht egal ist, wird nur nach dem Reiseziel gefiltert
                pstmt = con.prepareStatement("SELECT * FROM profils, users WHERE destination = ? AND profils.user_id = users.id ");
                pstmt.setString(1, destination);
            } else {
            //Möchte der User nur weibliche oder männliche Travelmates angezeigt bekommen,
            //so wird sowohl nach dem Reiseziel, als auch dem Gelecht gefiltert
                pstmt = con.prepareStatement("SELECT * FROM profils, users WHERE destination = ? AND profils.user_id = users.id AND sex = ?");
                pstmt.setString(1, destination);
                pstmt.setString(2, gender);
            }

            ResultSet rs = pstmt.executeQuery();
            
            /*Für jeden TravelMate wird ein User-Objekt erstellt mit:
                 - user_id
                 - email
                 - name
                 - last_name
              Diese TravelMates werden dann in einer Liste ("travelmates") gespeichert */
            while (rs.next()) {
                User tm = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"), rs.getString("last_name"), rs.getString("looking_for"),rs.getString("startdate"));
                travelmates.add(tm);

            }
            rs.close();
            con.close();
            
            //Die TravelMate-Liste wird zurückgegeben:
            return travelmates;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
      /**
     * Web service operation
     */
    @WebMethod(operationName = "storeMessage")
    public String storeMessage(@WebParam(name = "senderId") int senderId, @WebParam(name = "recipientId") int recipientId, @WebParam(name = "message") String message) {
        try {
             /* Die neu geschriebene Nachricht wird mit 
                - Id des Senders
                - Id des Empfängers
                - Nachrichteninhalt
            
                in die Datenbank gespeichert. Das Attribut seen (ob eine Nachricht gelesen wurde),
                wird erstmal auf "false" gesetzt.          
            */
             
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO messages (senderId, recipientId, message, seen) VALUES (?,?,?,?)"); 
            
            pstmt.executeQuery("SET NAMES UTF8");
            pstmt.executeQuery("SET CHARACTER SET UTF8");
            pstmt.setInt(1, senderId);
            pstmt.setInt(2, recipientId);
            pstmt.setString(3, message);
            pstmt.setBoolean(4, false);
            pstmt.executeUpdate();

            con.close();
            String answer = "Added Message!";
            return answer;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showConversations")
    public List<User> showConversations(@WebParam(name = "user_id") int user_id) {
        try {
          
            /*
            In showConversations werden alle verschiedenen ChatParnter, mit dem der aktuelle User
            Nachrichten ausgetauscht hat, aus der Datenbank geholt und in einer Liste zurückgeben
            */
            
            List<User> chatPartner = new ArrayList();
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT senderId, user_id, email, name, last_name FROM messages, users,profils WHERE recipientId = ? AND senderId = users.id AND profils.user_id = users.id"); //where id = ?

            pstmt.setInt(1, user_id);
            
            ResultSet rs = pstmt.executeQuery();
            
            /*Für jeden ChatPartner wird ein User-Objekt erstellt mit:
                 - user_id
                 - email
                 - name
                 - last_name
              Diese ChatPartner werden dann in einer Liste ("chatParnter") gespeichert */
            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"), rs.getString("last_name"));;
                chatPartner.add(user);
            }
            
           
            rs.close();
            con.close();
            
            //Die ChatPartner-Liste wird zurückgegeben:
            return chatPartner;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showMessages")
    public List<Message> showMessages(@WebParam(name = "user_id") int user_id, @WebParam(name = "chatPartnerId") int chatPartnerId) {
      try {
          
            /*Es werden alle Nachrichten zurückgegeben, die zwischen dem aktuellen User und dem 
              ausgewählten Chatpartner ausgetauscht wurden. D.h. sowohl die Nachrichten, die der akutelle
              User an den ausgewählten Chatpartner gesendet, als auch die Nachrichten, die er vom 
              ausgewählten Chatpartner empfangen hat */
            
            List<Message> messages = new ArrayList();
            Connection con = travelmate_vs.getConnection();
            
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM messages WHERE (recipientId = ? OR recipientId = ?) AND (senderId = ? OR senderId = ?) ORDER BY time ASC"); 

            pstmt.setInt(1, user_id);
            pstmt.setInt(2, chatPartnerId);
            pstmt.setInt(3, user_id);
            pstmt.setInt(4, chatPartnerId);
            ResultSet rs = pstmt.executeQuery();
            
            /*Für jede Nachricht zwischen aktuellem User und ausgewähltem Chatpartner wird ein
              Message-Objekt erstellt mit:
                 - Nachrichteninhalt
                 - Id desjenigen, der die Nachricht gesendet hat
                 - Id desjenigen, der die Nachricht empfangen hat
              Diese Nachrichten werden dann in einer Liste ("messages") gespeichert */
            while (rs.next()) {
                Message m = new Message(rs.getString("message"), rs.getInt("senderId"), rs.getInt("recipientId"), false);
                messages.add(m);
            }
            rs.close();
            
            
            /*Für die empfangenen Nachrichten, die der aktuelle User sich gerade anzeigen lässt,
              wird seen auf true gesetzt,so kann unterschieden werden, welche Nachrichten gelesen und welche ungelesen sind:  */
            pstmt = con.prepareStatement("UPDATE messages SET seen = ? WHERE recipientId = ?  AND senderId = ? "); 
            
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, user_id);
            pstmt.setInt(3, chatPartnerId);
            int update = pstmt.executeUpdate();
           
            con.close();
            if (update == 1) {
                System.out.println("In messages: Column seen is updated!");
            } else {
                System.out.println("Error! In messages: Could not update column seen");
            }            
            //Die Nachrichtenliste wird zurückgegeben:
            return messages;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "anyNewMessages")
    public List<User> anyNewMessages(@WebParam(name = "user_id") int user_id) {
         try {
             
            /*Es wird geprüft, ob der aktueller User neue Nachrichten (die er also noch nicht gelesen hat)
             erhalten hat, ist dies der Fall, so wird im Posteingang (Inbox) neben dem 
             Namen des Chatparnters "-New message(s)!" angezeigt
             
             Dazu wird in der Datanbank geschaut, welche Message der aktuelle Nutzer noch nicht
             gesehen hat (seen = false). Dann werden die Nutzer aus der Datenbank geholt, die die noch nicht 
             gesehenden Nachrichten gesendet haben und in einer Liste wieder zurückgeben.
             Man erhält also eine Liste mit Chatpartnern, die neue Nachrichten geschrieben haben, die der
             User noch nicht gelesen hat.
            */
            
            List<User> newMessagesFrom = new ArrayList();
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT seen, user_id, email, name, last_name FROM messages, users, profils WHERE messages.seen = ? AND recipientId = ? AND senderId = users.id AND users.id = profils.user_id");

            pstmt.setBoolean(1, false);
            pstmt.setInt(2, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("name"), rs.getString("last_name"));;
                newMessagesFrom.add(user);
            }
            rs.close();
            con.close();
            return newMessagesFrom;
         }
         catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    
    


}
