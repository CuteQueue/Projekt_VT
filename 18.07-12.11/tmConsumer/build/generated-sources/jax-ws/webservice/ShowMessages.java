
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für showMessages complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="showMessages"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="chatPartnerId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "showMessages", propOrder = {
    "userId",
    "chatPartnerId"
})
public class ShowMessages {

    @XmlElement(name = "user_id")
    protected int userId;
    protected int chatPartnerId;

    /**
     * Ruft den Wert der userId-Eigenschaft ab.
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Legt den Wert der userId-Eigenschaft fest.
     * @param value wird übergeben
     */
    public void setUserId(int value) {
        this.userId = value;
    }

    /**
     * Ruft den Wert der chatPartnerId-Eigenschaft ab.
     * @return chatPartnerId
     */
    public int getChatPartnerId() {
        return chatPartnerId;
    }

    /**
     * Legt den Wert der chatPartnerId-Eigenschaft fest.
     * @param value wird übergeben
     */
    public void setChatPartnerId(int value) {
        this.chatPartnerId = value;
    }

}
