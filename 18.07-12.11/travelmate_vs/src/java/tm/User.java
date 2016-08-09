/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuela
 */
public class User {

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

    public User(int user_id, String email, String name, String last_name, String looking_for, String startdate) {
        //Folgende Attribute werden von tm_Consumer benötigt:
        this.user_id = user_id;
        this.email = email;
        this.name = name;
        this.last_name = last_name;
        this.looking_for = looking_for;
        this.startdate = startdate;
    }
    
     public User(int user_id, String email, String name, String last_name){
        //Folgende Attribute werden von tm_Consumer benötigt:
        this.user_id = user_id;
        this.email = email;
        this.name = name;
        this.last_name = last_name;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

}
