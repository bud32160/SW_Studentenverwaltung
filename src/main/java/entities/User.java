package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="USER_TABLE")
public class User implements Serializable {
    
    @Id
    @Column(name="User_Id")
    private int id;
    
    @Column(name="Username")
    private String userName;
    
    @Column(name="Password")
    private String password;
        
    @XmlTransient
    @Column(name="salt")
    private String salt;
    
    @Column(name="MailAddress")
    private String mailAddress;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Student student;

    public User() {
    }

    public User(int id, String userName, String password, String salt, String mailAddress, Student student) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.mailAddress = mailAddress;
        this.student = student;
    }
    
    // Getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
