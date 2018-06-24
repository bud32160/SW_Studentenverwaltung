
package controller;


import entities.User;
import enumerations.ERole;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@ManagedBean(name = "logInController", eager = true)
@RequestScoped
public class LogInController implements Serializable{
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    public User logIn(String username, String password){
        
        TypedQuery<User> query = em.createNamedQuery("User.getUserByUsername", User.class);
        query.setParameter("username", username);

        try{
            User user = query.getSingleResult();
            return user;
        }
        catch(NoResultException e){
            return null;
        }
    }
    
    public String logOut(){
        
        return "LogOut";
    }
    
    public String registerSite(){
        
        return "RegistrationView";
    }
    
    /**
     * Checks which kind of user signs in
     * @param user
     * @return
     * 
     *     public String checkUserModel(User user){
        ERole roleModel = ERole.PROFESSOR;
        
        if(user.getRoleModel().equals(roleModel)){
            return "AdministrationOverview";
        }
        else{
            return "StudentOverview";
        }
    }
     * 
     * 
     */


}
