package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    
    @Id
    private String ID;
    private String roleUserId;
    private String userName;
    private String password;
    private String mailAddress;

    public User() {
    }

    public User(String ID, String roleUserId, String userName, String password, String mailAddress) {
        this.ID = ID;
        this.roleUserId = roleUserId;
        this.userName = userName;
        this.password = password;
        this.mailAddress = mailAddress;
    }
    
    // Getter and setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(String roleUserId) {
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
