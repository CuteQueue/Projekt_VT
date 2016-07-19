/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import java.sql.Connection;
import java.sql.Date;
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
    public String newUser(@WebParam(name = "name") String name, @WebParam(name = "last_name") String last_name, @WebParam(name = "email") String email, @WebParam(name = "salt") byte[] salt, @WebParam(name = "password") byte[] password) {
        try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (name, last_name, email, salt, password) VALUES (?,?,?,?,?)"); //where id = ?
            
            pstmt.setString(1, name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setBytes(4, salt);
            pstmt.setBytes(5, password);
            pstmt.executeUpdate();
            //rs.next();
            //byte[] encryptedPw = rs.getBytes("password");
            //rs.close();
            con.close();
            String answer = "User added to db!";
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
    public String createProfile(@WebParam(name = "mobilenumber") String mobilenumber, @WebParam(name = "age") int age, @WebParam(name = "location") String location, @WebParam(name = "sex") String sex, @WebParam(name = "destination") String destination, @WebParam(name = "startdate") Date startdate, @WebParam(name = "interests") String interests, @WebParam(name = "looking_for") String looking_for, @WebParam(name = "about") String about) {
       try {
            //TODO write your implementation code here:
            Connection con = travelmate_vs.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO profiles VALUES (?,?,?,?,?,?,?,?,?)"); //where id = ?
            
            pstmt.setString(1, mobilenumber);
            pstmt.setInt(2, age);
            pstmt.setString(3, location);
            pstmt.setString(4, sex);
            pstmt.setString(5, destination);
            pstmt.setDate(3, startdate);
            pstmt.setString(4, interests);
            pstmt.setString(5, looking_for);
            pstmt.setString(5, about);
            pstmt.executeUpdate();
            //rs.next();
            //byte[] encryptedPw = rs.getBytes("password");
            //rs.close();
            con.close();
            String answer = "Profile added to db!";
            return answer;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    
    
    
    
    
}
