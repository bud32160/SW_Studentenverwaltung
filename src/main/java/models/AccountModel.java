package models;

import entities.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.AccountService;

@Named
@SessionScoped
public class AccountModel implements Serializable {
    
    @Inject
    private AccountService accountService;
    
    private int ID;
    private int roleUserId;
    private String username;
    private String password;
    private String mailAdress;
    
    public void createUser(){
        // Serviceabhängigkeit
        accountService.createUserAccount(new User(this.ID, this.roleUserId, this.username,
                this.password, this.mailAdress));
    }

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

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

}
