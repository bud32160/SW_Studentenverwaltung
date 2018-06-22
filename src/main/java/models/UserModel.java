package models;

import controller.LogInController;
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
    
    @Inject
    private LogInController logInController;
    
    private Long ID;
    private Long roleUserId;
    private String username;
    private String password;
    private String mailAdress;
    
    public void createUser(){
        // Serviceabhängigkeit
        accountService.createUserAccount(new User(this.ID, this.roleUserId, this.username,
                this.password, this.mailAdress));
    }
    
    public String logIn(){
        String result = logInController.logIn(this);
    
        return result;
    }
    
    public String logOut(){
		
        String result = logInController.logOut();
        
        return result;
    }

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
