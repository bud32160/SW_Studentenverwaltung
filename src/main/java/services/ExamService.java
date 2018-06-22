package services;

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
        Exam e = exam;
        
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
            
        return exam;
    }
    
    @Transactional
    public boolean deleteExam(Exam exam){
        Exam e = em.find(Exam.class, exam.getId());
        
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
        
        return true;
    }

    @Transactional
    public void signInExam(Student student, Exam exam){
        FacesContext context = FacesContext.getCurrentInstance();
        Exam e = em.find(Exam.class, exam.getId());
        
        // Check if capacity is already exhausted
        if(e.getCapacity() <= 0){
            context.addMessage(null, new FacesMessage("Die maximale Anzahl an Prüfungsteilnehmern ist bereits belegt!"));
        }
        else{
            em.getTransaction().begin();
            e.addParticipant(student);
            em.getTransaction().commit();
            
            context.addMessage(null, new FacesMessage("Erfolgreich für die Prüfung angemeldet!"));
        }
    }
    
    @Transactional
    public void signOutExam(Student student, Exam exam){
        FacesContext context = FacesContext.getCurrentInstance();
        Exam e = em.find(Exam.class, exam.getId());
        
        em.getTransaction().begin();
        e.getParticipants().remove(student);
        em.getTransaction().commit();
        
        context.addMessage(null, new FacesMessage("Erfolgreich aus der Prüfung abgemeldet!"));
    }
     
}
