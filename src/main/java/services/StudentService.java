package services;

import entities.Address;
import entities.Course;
import entities.Student;
import entities.User;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@RequestScoped
public class StudentService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    public Student getStudent(User user){
        User studentUser;
        
        // search for studentobject
        String selectCommand = "SELECT u from User AS u WHERE mailAddress = " + user.getMailAddress();
        TypedQuery<User> query = em.createQuery(selectCommand, User.class);
        studentUser = query.getSingleResult();
        
        // check if password is correct
        if(user.getPassword().equals(studentUser.getPassword()))
        {
            String s = "SELECT s FROM STUDENT AS s WHERE mailAddress = " + user.getMailAddress();
            // return the student object
            TypedQuery<Student> q = em.createQuery(s, Student.class);
            
            return q.getSingleResult();
        }
        else{
            return null;
        }
    }
    
    @Transactional
    public void changeAddress(Student student, Address newAddress){
        
        Address address = em.find(Address.class, student.getAddressId());
        
        address.setStreet(newAddress.getStreet());
        address.setHouseNumber(newAddress.getHouseNumber());
        address.setCity(newAddress.getCity());
        address.setZipCode(newAddress.getZipCode());
        address.setCountry(newAddress.getCountry());
        
        em.persist(address);
    }

    
    public String signInCourse(Student student, Course course){
        String selectCommand = "SELECT c FROM COURSE AS c WHERE ID = " + course.getID();
         TypedQuery<Course> query = em.createQuery(selectCommand, Course.class);
         
        Course c = query.getSingleResult();
        
        if(c.getCapacity() > 0){
            String updateCommand = "UPDATE COURSER SET CAPACITY = " + (course.getCapacity() - 1) + " WHERE ID = " + course.getID();
            
            return "Erfolgreich eingeschrieben!";
        }
        else{
            return "Einschreiben nicht möglich!";
        }  
    }
    
    
    
    
    
}
