package services;

import entities.Address;
import entities.Student;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class StudentService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    @Transactional
    public void createStudent(Address address, Student student){
        em.persist(address);
        em.persist(student);
    }
    
    
}
