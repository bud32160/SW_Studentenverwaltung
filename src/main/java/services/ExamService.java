

package services;

import entities.Course;
import entities.Exam;
import entities.Student;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@RequestScoped
public class ExamService {
       
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    public List<Exam> getAllExams(){
        TypedQuery<Exam> query = em.createNamedQuery("Exam.getAllExams", Exam.class);
        
        try{
            return query.getResultList(); 
        } 
        catch(Exception ex){
           return null;
        }
    }
    
    @Transactional
    public Exam createExam(Exam exam){
        try{
            Exam e = exam;

            em.persist(e);
            em.flush();
            
            return exam;
        } catch(Exception ex){
            return null;
        }
        

    }
    
    @Transactional
    public boolean deleteExam(Exam exam){
        
        try{
            Exam e = em.find(Exam.class, exam.getId());
        
            em.remove(e);
            em.flush();
        
            return true;
        } catch(Exception e){
            return false;
        }

    }

    @Transactional
    public boolean signInExam(Student student, Exam exam){

        try{
            Exam e = em.find(Exam.class, exam.getId());
            Student s = em.find(Student.class, student.getId());
            
            if(examContainsStudent(s, e))
                return false;
            
            // Check if capacity is already exhausted
            if(e.getCapacity() <= 0){
            
                return false;
            }
            else{
                s.getExamList().add(e);
                em.merge(s);
                
                e.setCapacity(e.getCapacity() - 1);
                e.addParticipant(student);
                em.merge(e);
                em.flush();
            
                return true;
            }
        } catch(Exception ex){
            return false;
        }   
    }
    
    public boolean examContainsStudent(Student student, Exam exam){
        for(Student s : exam.getParticipants()){
            if(s.getId().toString().equals(student.getId().toString()))
                return true;
        }
        
        return false;
    }
    
    @Transactional
    public boolean signOutExam(Student student, Exam exam){
      
        try{
            Student s = em.find(Student.class, student.getId());
            Exam e = em.find(Exam.class, exam.getId());
            
            s.getExamList().remove(e);
            em.merge(s);
            
            e.getParticipants().remove(student);
            e.setCapacity(e.getCapacity() + 1);
            em.merge(e);
            em.flush();
            
            return true;
        } catch(Exception ex){
            return false;
        }
    }
    
        public Exam getExamByDescription(String description){
        
        try{
            TypedQuery<Exam> query = em.createNamedQuery("Exam.getExameByDescription", Exam.class);
            query.setParameter("description", description);
            
            Exam e = query.getSingleResult();
        
            return e;
        } catch(Exception ex){
            
            return null;
        }    
    }
     
}
