/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmate;
import users_profils.service.ProfilsFacadeREST;
import users_profils.service.UsersFacadeREST;
import users_profils.Users;

/**
 *
 * @author Manuela
 */
public class TravelMate {
    Users user;
    
    public TravelMate(){
        user = new Users(25);
    }
    
    public String validate(String mail, String pw){
        String returnvalue = "nix";
        if (mail == user.getEmail()){
            returnvalue = "mail.korrekt@mail.de";
        }else {
            returnvalue = "mail.falsch@mail.de";
        }
        return returnvalue;
    }
    
    
}
