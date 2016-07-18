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
    
    
}
