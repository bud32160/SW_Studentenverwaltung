package services;

import entities.Student;
import entities.User;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    
    
}
