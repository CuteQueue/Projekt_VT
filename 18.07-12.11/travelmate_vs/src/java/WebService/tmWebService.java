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
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;
import static sun.security.krb5.Confounder.bytes;
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
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getName")
    public String getName(@WebParam(name = "id") int id) {
        try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE id = ?"); //where id = ?

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            //String text = "butz";
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
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "email") String email, @WebParam(name = "pw") String pw) {
        try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?"); //where id = ?

            pstmt.setString(1, email);
            pstmt.setString(2, pw);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            //String text = "butz";
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
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (name, last_name, nickname, email, salt, password) VALUES (?,?,?,?,?,?)"); //where id = ?

            pstmt.setString(1, name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, nickname);
            pstmt.setString(4, email);
            pstmt.setBytes(5, salt);
            pstmt.setBytes(6, password);
            pstmt.executeUpdate();
            //rs.next();
            //byte[] encryptedPw = rs.getBytes("password");
            //rs.close();
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
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO profils (user_id, mobilenumber, age, location, sex, destination, startdate, interests, looking_for, about) VALUES (?,?,?,?,?,?,?,?,?,?)"); //where id = ?

            pstmt.setInt(1, id);
            pstmt.setString(2, mobilenumber);
            pstmt.setInt(3, age);
            pstmt.setString(4, location);
            pstmt.setString(5, sex);
            pstmt.setString(6, destination);
            // pstmt.setDate(7, startdate);
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
            PreparedStatement pstmt = con.prepareStatement("UPDATE profils SET mobilenumber = ?, age = ?, location = ?, sex = ?, destination = ?, startdate = ?, interests = ?, looking_for = ?, about = ? WHERE user_id = ?"); //where id = ?

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
            //rs.next();
            //byte[] encryptedPw = rs.getBytes("password");
            //rs.close();
            con.close();
            System.out.println(id);
            System.out.println(age);
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
            
            
            if (gender.equals("both")){
                pstmt = con.prepareStatement("SELECT * FROM profils, users WHERE destination = ? AND profils.user_id = users.id ");
                pstmt.setString(1, destination);
            }else{
                 pstmt = con.prepareStatement("SELECT * FROM profils, users WHERE destination = ? AND profils.user_id = users.id AND sex = ?");
                 pstmt.setString(1, destination);
                 pstmt.setString(2, gender);
            }
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                User tm = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("last_name"), rs.getString("looking_for"));
                travelmates.add(tm);

            }
            rs.close();
            con.close();
            return travelmates;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }


}
