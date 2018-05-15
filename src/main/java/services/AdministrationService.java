package services;

import entities.Address;
import entities.Course;
import entities.Exam;
import entities.Room;
import entities.Student;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
public class AdministrationService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    @Transactional
    public void createStudent(Address address, Student student){
        em.persist(address);
        em.persist(student);
    }
    
    @Transactional
    public void createCourse(Course course){
        em.persist(course);
    }
    
    @Transactional
    public void createRoom(Room room){
        em.persist(room);
    }
    
    @Transactional
    public void createExam(Exam exam){
        em.persist(exam);
    }
  
}
