package entities;

import enumerations.ERole;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import util.SingleIdEntity;

@Entity
@Table(name="USER_TABLE")
@NamedQueries({
@NamedQuery(name = "User.getUserByMailAddress", query = "SELECT u FROM User AS u WHERE u.mailAddress = :mailAddress" ),
@NamedQuery(name = "User.getUserByUsername", query = "SELECT u FROM User AS u WHERE u.username = :username" )
})
public class User extends SingleIdEntity implements Serializable {
    
    @Column(name="User_MailAddress")
    private String mailAddress;
    
    @Column(name="Role_Id")
    private Long roleId;
    
    @Column(name="Username")
    private String username;
    
    @Column(name="Password")
    private String password;
        
    @XmlTransient
    @Column(name="salt")
    private String salt;
    
    @Column(name="Role_Model")
    private ERole roleModel;

    public User() {
    }

    public User(Long roleId, String username, String password, String salt, String mailAddress) {
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.mailAddress = mailAddress;
    }
    
    // Getter and setter
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public ERole getRoleModel() {
        return roleModel;
    }

    public void setRole(ERole roleModel) {
        this.roleModel = roleModel;
    }
    
    
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

}
