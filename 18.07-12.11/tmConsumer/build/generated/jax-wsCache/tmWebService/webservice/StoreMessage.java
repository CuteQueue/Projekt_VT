
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für storeMessage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="storeMessage"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="recipientId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "storeMessage", propOrder = {
    "senderId",
    "recipientId",
    "message"
})
public class StoreMessage {

    protected int senderId;
    protected int recipientId;
    protected String message;

    /**
     * Ruft den Wert der senderId-Eigenschaft ab.
     * 
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * Legt den Wert der senderId-Eigenschaft fest.
     * 
     */
    public void setSenderId(int value) {
        this.senderId = value;
    }

    /**
     * Ruft den Wert der recipientId-Eigenschaft ab.
     * 
     */
    public int getRecipientId() {
        return recipientId;
    }

    /**
     * Legt den Wert der recipientId-Eigenschaft fest.
     * 
     */
    public void setRecipientId(int value) {
        this.recipientId = value;
    }

    /**
     * Ruft den Wert der message-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Legt den Wert der message-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
