package services;

import entities.Administrator;
import entities.User;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
