package services;

import entities.Course;
import entities.Room;
import entities.Student;
import enumerations.EDay;
import enumerations.ETime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@RequestScoped
public class CourseService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    public List<Course> getAllCourse(){
        TypedQuery<Course> query = em.createNamedQuery("Course.getAllCourse", Course.class);
        try{
            return query.getResultList(); 
        } 
        catch(Exception ex){
           return null;
        }
    }
    
    @Transactional
    public Course createCourse(Course course){
        Course c = course;
        
        em.persist(c);
        em.flush();
            
        return course;
    }
    
    @Transactional
    public boolean deleteCourse(Course course){
        Course c = em.find(Course.class, course.getId());
        
        em.remove(c);
        em.flush();
        
        return true;
    }
    
    @Transactional
    public Course updateCourse(Course course){
        course = em.merge(course);
        em.flush();

        return course;
    }
    
    @Transactional
    public boolean signInCourse(Student student, Course course){
        
        Course c = em.find(Course.class, course.getId());
        
        if(c == null){
            return false;
        }
        
        // Check if capacity is already exhausted
        if(c.getCapacity() <= 0){
            return false;
        } 
        else{
            c.addParticipant(student);
            em.flush();
            
            return true;
        }
    }
    
    @Transactional
    public boolean signOutCourse(Student student, Course course){
        
        Course c = em.find(Course.class, course.getId());
        
        if(c == null){
            return false;
        }
        
        em.remove(c);
        em.flush();
            
        return true;     
    }
    
    /**
     * Find free time slots for room reservation
     * @param room
     * @param day
     * @return timeList
     */
    public List<ETime> getFreeTimeSlots(Room room, EDay day){
        List<ETime> timeList = new ArrayList<>(Arrays.asList(ETime.values()));
        String selectCommand = "SELECT c FROM COURSE AS c WHERE roomId = " + Long.toString(room.getId()) + " AND EDay = " + day;
        TypedQuery<Course> query = em.createQuery(selectCommand, Course.class);
        List<Course> courseList;
        
        try{
            courseList = query.getResultList();
        } catch (NoResultException e){
            return timeList;
        }
  
        // If there is no course in this room at that day
        if(courseList == null || courseList.size() <= 0){
            return timeList;
        }
        else {
            timeList = createTimeList(timeList, courseList);
            return timeList;
        }   
    }
    
    /**
     * Create list of free time spaces depending on courses on that day
     * @param timeList
     * @param courseList
     * @return timeList
     */
    private List<ETime> createTimeList(List<ETime> timeList, List<Course> courseList){
        ETime time;
        // return free time slots
        for(Course course : courseList){
            time = course.getETime();
                
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
