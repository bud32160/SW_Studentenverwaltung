package services;

import entities.Course;
import entities.Room;
import entities.Student;
import entities.User;
import enumerations.EDay;
import enumerations.ETime;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<Course> list = null;
        
        try{
            list = query.getResultList();
        } catch(NoResultException e){
            context.addMessage(null, new FacesMessage("Kein Kurs vorhanden"));
        }
        
        return list;
    }
    
    public List<ETime> getFreeTimeSlots(Room room, EDay day){
        List<ETime> timeList = new ArrayList<>(Arrays.asList(ETime.values()));
        String selectCommand = "SELECT c FROM COURSE AS c WHERE roomId = " + room.getID() + " AND EDay = " + day;
        TypedQuery<Course> query = em.createQuery(selectCommand, Course.class);
        
        List<Course> courseList = query.getResultList();
            
        // If there is no course in this room at that day
        if(courseList == null || courseList.size() <= 0){
            return timeList;
        }
        else {
            
            timeList = createTimeList(timeList, courseList);
            return timeList;
        }   
    }
    
    private List<ETime> createTimeList(List<ETime> timeList, List<Course> courseList){
        
        // return free time slots
        for(Course course : courseList){
            ETime time = course.getETime();
                
            // Remove reservated time slots
            for(ETime t : timeList){
                if(t.equals(time)){
                    timeList.remove(t);
                    break;
                }
            }
        }
            
        return timeList;
    }
    
    
    
}
