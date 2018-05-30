package services;

import entities.Course;
import entities.Student;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@RequestScoped
public class CourseService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    public List<Course> getAllCourse(){
        String selectCommand = "SELECT c FROM COURSE AS c";
        TypedQuery<Course> query = em.createQuery(selectCommand, Course.class);
        FacesContext context = FacesContext.getCurrentInstance();
        List<Course> courseList = null;
        
        try{
            courseList = query.getResultList();
        } catch(NoResultException e){
            context.addMessage(null, new FacesMessage("Kein Kurs vorhanden"));
        }
        
        return courseList;
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
