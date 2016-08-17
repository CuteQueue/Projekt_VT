
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="recipientId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seen" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "recipientId",
    "seen",
    "senderId"
})
public class Message {

    protected String content;
    protected int recipientId;
    protected boolean seen;
    protected int senderId;

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
     * Ruft den Wert der recipientId-Eigenschaft ab.
     * @return recipientId
     */
    public int getRecipientId() {
        return recipientId;
    }

    /**
     * Legt den Wert der recipientId-Eigenschaft fest.
     * @param value wird übergeben
     */
    public void setRecipientId(int value) {
        this.recipientId = value;
    }

    /**
     * Ruft den Wert der seen-Eigenschaft ab.
     * @return seen
     */
    public boolean isSeen() {
        return seen;
    }

    /**
     * Legt den Wert der seen-Eigenschaft fest.
     * @param value wird übergeben
     */
    public void setSeen(boolean value) {
        this.seen = value;
    }

    /**
     * Ruft den Wert der senderId-Eigenschaft ab.
     * @return senderId
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * Legt den Wert der senderId-Eigenschaft fest.
     * @param value wird übergeben
     */
    public void setSenderId(int value) {
        this.senderId = value;
    }

}
