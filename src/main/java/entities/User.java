package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    
    @Column(name="RoleUserId")
    private Long roleUserId;
    
    @Column(name="Username")
    private String userName;
    
    @Column(name="Password")
    private String password;
    
    @Column(name="Mailaddress")
    private String mailAddress;

    public User() {
    }
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(Long ID, Long roleUserId, String userName, String password, String mailAddress) {
        this.ID = ID;
        this.roleUserId = roleUserId;
        this.userName = userName;
        this.password = password;
        this.mailAddress = mailAddress;
    }
    
    // Getter and setter
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(Long roleUserId) {
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
