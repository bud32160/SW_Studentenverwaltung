package services;

import entities.Administrator;
import entities.User;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@RequestScoped
public class AccountService {
    
   @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    @Transactional
    public void createUserAccount(User user){
        em.persist(user);
    }
    
    public void createAdminAccount(Administrator administrator){
        em.persist(administrator);
        
    }
    
    public String logIn(User user){
        String userName = user.getUserName();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User AS u WHERE u.userName LIKE('" + userName + "')", User.class);
        FacesContext context = FacesContext.getCurrentInstance();
        User u;
        
        try{
            u = query.getSingleResult();
        }
        catch(NoResultException e){
            context.addMessage(null, new FacesMessage("Username oder Passwort nicht korrekt"));
            return "logIn.xhtml";
        }
        
        if(u.getPassword().equals(user.getPassword())){
            return "administration.xhtml";
        }
        else{
            context.addMessage(null, new FacesMessage("Username oder Passwort nicht korrekt"));
            return "logIn.xhtml";
        }
    }
}
