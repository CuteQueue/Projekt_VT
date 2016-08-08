/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

/**
 *
 * @author nina
 */
public class Message {
    private String content;
    private int user_id;
    private int friendId;
    
    public Message (String content, int user_id, int friendId){
        
        this.content = content;
        this.user_id = user_id;
        this.friendId = friendId;
        System.out.println("New Message created!");
        
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }
    
}
