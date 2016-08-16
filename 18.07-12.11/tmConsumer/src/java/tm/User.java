
package tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* <h1>User</h1>
* Schablone für User-Objekt mit Userdaten 
* aus der Datenbank
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class User {
    String host = "jdbc:mysql://localhost:3306/trvmate_db?zeroDateTimeBehavior=convertToNull";
    String uName = "root";
    String uPass= "root";
    Connection con;
    Statement stmt;
    ResultSet rs;    
    
    private String name = null;
    private String last_name = null;
    private String nickname = null;
    private String email = null;
    private String mobilenumber = null;
    private String location = null;
    private String created_at = null;
    private String updated_at = null;
    private String sex = null;
    private String destination = null;
    private String startdate = null;
    private String interests = null;
    private String looking_for = null;
    private String about = null;
    private int id;
    private int user_id;
    private int age;
    
    /**
   * User-Konstruktor
   * @param email User-Email
   */
    public User (String email){
        this.email = email;
        connect();
        getUserData();
    }
    
    /**
   * erstellt Verbindung zur Datenbank
   */
    public void connect(){
        try {
            con = DriverManager.getConnection(host, uName, uPass);
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) );
        } 
    }
    
    /**
   * holt Userdaten id, name, last_name, nickname, created_at aus Datenbank
   */
    public void getUserData(){
        String returnUser = "kein User gefunden";
        try {
            stmt = con.createStatement();
            String SQL = "SELECT * FROM users WHERE email = \"" + this.email + "\"";
            rs = stmt.executeQuery(SQL);
        
            rs.next();
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.last_name = rs.getString("last_name");
            this.nickname = rs.getString("nickname");
            this.created_at = rs.getString("created_at");
            
            String SQL2 = "SELECT * FROM profils WHERE user_id = " + this.id;
            rs = stmt.executeQuery(SQL2);
            rs.next();
          
            returnUser = name + " " + last_name  + " wurde angelegt.";
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }    
        System.out.println(returnUser);
    }
    
    /**
   * holt Profildaten des Users aus der Datenbank
   */
      public void getProfileData(){
        try {
            stmt = con.createStatement();
            String SQL = "SELECT * FROM users WHERE email = \"" + this.email + "\"";
            rs = stmt.executeQuery(SQL);
        
            rs.next();
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.last_name = rs.getString("last_name");
  
            String SQL2 = "SELECT * FROM profils WHERE user_id = " + this.id;
            rs = stmt.executeQuery(SQL2);
            
            rs.next();
            this.mobilenumber = rs.getString("mobilenumber");
            this.location = rs.getString("location");
            this.updated_at = rs.getString("updated_at");
            this.sex = rs.getString("sex");
            this.destination = rs.getString("destination");
            this.startdate = rs.getString("startdate");
            this.interests = rs.getString("interests");
            this.looking_for = rs.getString("looking_for");
            this.about = rs.getString("about");
            this.user_id = rs.getInt("user_id");
            this.age = rs.getInt("age");
                
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getLooking_for() {
        return looking_for;
    }

    public void setLooking_for(String looking_for) {
        this.looking_for = looking_for;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
    
}
