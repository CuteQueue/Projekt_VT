/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelmate;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author nina
 */
public class TravelMate {

    static private String servlet_ctxt;

    public TravelMate(String ctxt) {
        TravelMate.servlet_ctxt = ctxt;

    }
    
    private class BillBoardEntry {
        int id;
        String text;
        String owner_ip;

        public BillBoardEntry(int i, String text, String caller_ip) {
            id = i;
            this.text = text;
            owner_ip = caller_ip;
        }
         
        public void reset () {
            this.text = "<empty>";
            owner_ip = "<not set>";
        }
        
        /**
         * Billboard-Eintrag wird als html-Tabellenzeile ausgegeben.
         * 
         * @param caller_ip
         * @return html-formatierter Eintrag
         */
        public String getEntry(String caller_ip) {
            StringBuilder result = new StringBuilder();
            result.append("<tr><td>" + this.id + "</td>");
            result.append("<td>");
            
            String disable_edits = "";
            if (!belongsToCaller(caller_ip)) {
                disable_edits = " style=\"background-color: #eeeeee;\" readonly";
            }
            result.append("<input type=\"text\" size=\"100\" "
                    + "minlength=\"100\" "
                    + "maxlength=\"100\" "
                    + "id=\"input_field_" + id + "\" "
                    + "value=\"" + text  + "\"" + disable_edits + ">");
            result.append("</td>");
            result.append("<td>");
            if (belongsToCaller(caller_ip)) {
                result.append("<button onClick=\"putHttpRequest('" +  
                        TravelMate.servlet_ctxt + "',"
                        + id + ")\">Update</button>");
            }
            result.append("</td>");
            result.append("<td>");
            if (belongsToCaller(caller_ip)) {
                result.append("<button onClick=\"deleteHttpRequest('" +  
                        TravelMate.servlet_ctxt + "',"
                        + + id + ")\">Delete</button>");
            }
            result.append("</td>");
            result.append("</tr>\n");
            return result.toString();
        };

        private boolean belongsToCaller(String caller_ip) {
            if (caller_ip.equals(this.owner_ip))
                return true;
            return false;
        }
        
        public JsonObject getEntryJason(String caller_ip){
            JsonObjectBuilder builder = Json.createObjectBuilder();
            builder.add("id", this.id);
            builder.add("text", this.text);
            builder.add("servlet_ctxt", TravelMate.servlet_ctxt);
            builder.add("belongs_to_caller", belongsToCaller(caller_ip));
            
            JsonObject jo = builder.build();            
            return jo;
        }
    }

    private int pickIndex () {
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1);
        return randomNum;
    }
    /**
     * Hinzufügen eines Eintrags.
     * Aus Gründen der Einfachheit und der Performanz 
     * wird ein vorhandener Eintrag (vergleichbar einer
     * Plakatwand) überschrieben.
     * 
     * @param text Plakat-Text
     * @param poster_ip IP-Adresse des Senders 
     */
    public void createEntry (String text, String poster_ip) {
        
        }
        /* Erstbestes Element auswählen */
        /*if (freelist.isEmpty()) {
            for (int i = 0; i < SIZE; i++) {
                freelist.add(i);
            }
        }*/
        
    

    /**
     * Löschen eines Eintrags via id.
     * 
     * @param idx 
     */
    public void deleteEntry (int idx) {
      
    }
    
    /**
     * Aktualisierung eines Eintrags.
     * 
     * @param idx id des Eintrags
     * @param text Zu ersetzender Text
     * @param poster_ip IP-Adresse des Senders
     */
    public void updateEntry (int idx, String text, String poster_ip) {
       
    }
    
    /**
     * Lesen eines Eintrags. Der Eintrag wird als html-Tabelle
     * zurückgegeben und kann ohne weiteres in ein html-Dokument
     * eingebunden werden.
     * 
     * @param caller_ip IP-Adresse des Aufrufers
     * @return Eintrag als html-Tabelle
     */
    public String readContents(String caller_ip) {
        
        return "TEST";
    };
    
    
    public String readContentsJson(String caller_ip){
       return "TEST";
    }
    
}
