
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für message complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="message"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="friendId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seen" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message", propOrder = {
    "content",
    "friendId",
    "seen",
    "userId"
})
public class Message {

    protected String content;
    protected int friendId;
    protected boolean seen;
    @XmlElement(name = "user_id")
    protected int userId;

    /**
     * Ruft den Wert der content-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Legt den Wert der content-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Ruft den Wert der friendId-Eigenschaft ab.
     * 
     */
    public int getFriendId() {
        return friendId;
    }

    /**
     * Legt den Wert der friendId-Eigenschaft fest.
     * 
     */
    public void setFriendId(int value) {
        this.friendId = value;
    }

    /**
     * Ruft den Wert der seen-Eigenschaft ab.
     * 
     */
    public boolean isSeen() {
        return seen;
    }

    /**
     * Legt den Wert der seen-Eigenschaft fest.
     * 
     */
    public void setSeen(boolean value) {
        this.seen = value;
    }

    /**
     * Ruft den Wert der userId-Eigenschaft ab.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Legt den Wert der userId-Eigenschaft fest.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

}
