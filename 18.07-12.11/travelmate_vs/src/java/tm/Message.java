/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;
/**
* <h1>Messages</h1>
* Die Klasse Message erstellt Message-Objekte,
* um diese an den tm-Consumer weitergeben zu können.
* 
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class Message {
    private String content;
    private int senderId;
    private int recipientId;
    private boolean seen;
    
    /**
   * Message Konstruktur zum Erstellen von Messages-Objekten.
   * 
   * @param content Inhalt der Nachricht
   * @param senderId Email des Users
   * @param recipientId Email des Users
   * @param seen Email des Users
   */
    public Message (String content, int senderId, int recipientId, boolean seen){
        
        this.content = content;
        this.senderId = senderId; //user_id
        this.recipientId = recipientId;
        this.seen = seen;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    
}
