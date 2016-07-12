/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trvmate_db_webservices;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manuela
 */
@Entity
@Table(name = "profils")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profils.findAll", query = "SELECT p FROM Profils p"),
    @NamedQuery(name = "Profils.findById", query = "SELECT p FROM Profils p WHERE p.id = :id"),
    @NamedQuery(name = "Profils.findByUserId", query = "SELECT p FROM Profils p WHERE p.userId = :userId"),
    @NamedQuery(name = "Profils.findByMobilenumber", query = "SELECT p FROM Profils p WHERE p.mobilenumber = :mobilenumber"),
    @NamedQuery(name = "Profils.findByAge", query = "SELECT p FROM Profils p WHERE p.age = :age"),
    @NamedQuery(name = "Profils.findByLocation", query = "SELECT p FROM Profils p WHERE p.location = :location"),
    @NamedQuery(name = "Profils.findByCreatedAt", query = "SELECT p FROM Profils p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Profils.findByUpdatedAt", query = "SELECT p FROM Profils p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "Profils.findBySex", query = "SELECT p FROM Profils p WHERE p.sex = :sex"),
    @NamedQuery(name = "Profils.findByDestination", query = "SELECT p FROM Profils p WHERE p.destination = :destination"),
    @NamedQuery(name = "Profils.findByStartdate", query = "SELECT p FROM Profils p WHERE p.startdate = :startdate"),
    @NamedQuery(name = "Profils.findByInterests", query = "SELECT p FROM Profils p WHERE p.interests = :interests"),
    @NamedQuery(name = "Profils.findByLookingFor", query = "SELECT p FROM Profils p WHERE p.lookingFor = :lookingFor")})
public class Profils implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mobilenumber")
    private String mobilenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "age")
    private short age;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "destination")
    private String destination;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "interests")
    private String interests;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "looking_for")
    private String lookingFor;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "about")
    private String about;

    public Profils() {
    }

    public Profils(Integer id) {
        this.id = id;
    }

    public Profils(Integer id, int userId, String mobilenumber, short age, String location, String sex, String destination, Date startdate, String interests, String lookingFor, String about) {
        this.id = id;
        this.userId = userId;
        this.mobilenumber = mobilenumber;
        this.age = age;
        this.location = location;
        this.sex = sex;
        this.destination = destination;
        this.startdate = startdate;
        this.interests = interests;
        this.lookingFor = lookingFor;
        this.about = about;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profils)) {
            return false;
        }
        Profils other = (Profils) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trvmate_db_webservices.Profils[ id=" + id + " ]";
    }
    
}
