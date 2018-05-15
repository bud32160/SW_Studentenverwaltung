package services;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class StudentService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    
    
    
}
