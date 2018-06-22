package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import util.SingleIdEntity;

@Entity
@Table(name="USER_TABLE")
@NamedQueries({
@NamedQuery(name = "User.getUserByMailAddress", query = "SELECT u FROM User AS u WHERE u.mailAddress = :mailAddress" ),
@NamedQuery(name = "User.getUserByUsername", query = "SELECT u FROM User AS u WHERE u.username = :username" )
})
public class User implements Serializable {
    
    @Id
    @Column(name="User_MailAddress")
    private String mailAddress;
    
    @Column(name="Username")
    private String username;
    
    @Column(name="Password")
    private String password;
        
    @XmlTransient
    @Column(name="salt")
    private String salt;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Student student;

    public User() {
    }

    public User(String username, String password, String salt, String mailAddress, Student student) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.mailAddress = mailAddress;
        this.student = student;
    }
    
    // Getter and setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
   
}
