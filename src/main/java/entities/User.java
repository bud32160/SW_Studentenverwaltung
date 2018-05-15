package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    
    @Id
    @Column(name="Id")
    private int ID;
    private int roleUserId;
    private String userName;
    private String password;
    private String mailAddress;

    public User() {
    }

    public User(int ID, int roleUserId, String userName, String password, String mailAddress) {
        this.ID = ID;
        this.roleUserId = roleUserId;
        this.userName = userName;
        this.password = password;
        this.mailAddress = mailAddress;
    }
    
    // Getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(int roleUserId) {
        this.roleUserId = roleUserId;
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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
  
}
