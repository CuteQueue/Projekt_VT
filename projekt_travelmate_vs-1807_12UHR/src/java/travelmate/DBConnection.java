/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Manuela
 */
public class DBConnection {
    ResultSet rs;
    
public void connect(){
    try {
        String host = "jdbc:mysql://localhost:3306/trvmate_db?zeroDateTimeBehavior=convertToNull";
        String uName = "root";
        String uPass= "root";
        Connection con = DriverManager.getConnection(host, uName, uPass);
        System.out.println("connected!");
        Statement stmt = con.createStatement();
        String SQL = "SELECT * FROM users";
        
        rs = stmt.executeQuery(SQL);
        
        while(rs.next()){
            int idCol = rs.getInt("id");
            String firstName = rs.getString("name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");

            System.out.println(idCol + " " + firstName + " " + lastName + " " + email);
        }
        
    }
    catch ( SQLException err ) {
    System.out.println( err.getMessage( ) );
    } 
}
}
