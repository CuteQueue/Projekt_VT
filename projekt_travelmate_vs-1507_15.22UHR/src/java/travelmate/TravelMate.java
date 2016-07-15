/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmate;
import static java.lang.System.out;
import javax.persistence.EntityManager;
import users_profils.service.AbstractFacade;
import users_profils.service.ProfilsFacadeREST;
import users_profils.service.UsersFacadeREST;
import users_profils.*;

/**
 *
 * @author Manuela
 */
public class TravelMate {
    AbstractFacade <Users> user;
    Users userkonkr;

    public TravelMate (){
        user = new UsersFacadeREST();
        userkonkr = new Users();
    }
    
    public void print(){
        out.println("print1");
        userkonkr = user.find(25);
        out.println("print2");
        out.println(userkonkr.getLastName());
    }
    
    public String validate(String mail, String pw){
        String returnvalue = "nix";
        if (mail == user.find(25).getEmail()){
            returnvalue = "mail.korrekt@mail.de";
        }else {
            returnvalue = "mail.falsch@mail.de";
        }
        return returnvalue;
    }
    
    
}
