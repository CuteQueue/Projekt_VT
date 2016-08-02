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
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;
import static sun.security.krb5.Confounder.bytes;

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
            
            pstmt.setInt(1,id); 
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



    
    
    
    
    
}
