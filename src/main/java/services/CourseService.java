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
        
        try{
            Course c = course;
        
            em.persist(c);
            em.flush();
            
        return course;
        } catch(Exception ex){
            return null;
        }

    }
    
    public Course getCourseByDescription(String description){
        
        try{
            TypedQuery<Course> query = em.createNamedQuery("Course.getCourseByDescription", Course.class);
            query.setParameter("descrition", description);
            
            Course c = query.getSingleResult();
        
            return c;
        } catch(Exception ex){
            
            return null;
        }    
    }
    
    @Transactional
    public boolean deleteCourse(Course course){
        
        try{
            Course c = em.find(Course.class, course.getId());
        
            em.remove(c);
            em.flush();
        
            return true;
        } catch(Exception e){
            return false;
        }
        
    }
    
    @Transactional
    public Course updateCourse(Course course){
        
        try{
            course = em.merge(course);
        em.flush();

        return course;
        } catch(Exception ex){
            return null;
        }
    }
    
    @Transactional
    public boolean signInCourse(Student student, Course course){
        
        try{
             Course c = em.find(Course.class, course.getId());
             Student s = em.find(Student.class, student.getId());
             
             if(courseContainsStudent(s, c))
                return false;
             
            // Check if capacity is already exhausted
            if(c.getCapacity() <= 0){
                return false;
            } 
            else{
                s.getCourseList().add(c);
                em.persist(s);
                
                c.setCapacity(c.getCapacity() - 1);
                c.addParticipant(student);
                em.merge(c);
                em.flush();
            
            return true;
            }
        } catch(Exception e){
            return false;
        }  
    }
    
    public boolean courseContainsStudent(Student student, Course course){
        for(Student s : course.getParticipants()){
            if(s.getId().toString().equals(student.getId().toString()))
                return true;
        }
        
        return false;
    }
    
    @Transactional
    public boolean signOutCourse(Student student, Course course){
        
        try{            
            Student s = em.find(Student.class, student.getId());
            Course c = em.find(Course.class, course.getId());
            
            s.getCourseList().remove(c);
            em.merge(s);
            
            c.getParticipants().remove(student);
            c.setCapacity(c.getCapacity() + 1);
            em.merge(c);
            em.flush();
            
            return true;
        } catch(Exception ex){
            return false;
        }
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
        List<Course> courseList;
        
        try{
            TypedQuery<Course> query = em.createQuery(selectCommand, Course.class);
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
