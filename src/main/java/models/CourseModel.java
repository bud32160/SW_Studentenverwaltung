package models;

import entities.Course;
import entities.Room;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.AdministrationService;
import services.CourseService;

@Named
@SessionScoped
public class CourseModel implements Serializable {
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private AdministrationService administrationService;
    
    private Long courseID;
    private String description;
    private Long majorId;
    private String instructor;
    private String time;
    private Date date;
    private Long roomId;
    private int capacity;
    
    public void createCourse(Room room){
        
        administrationService.createCourse(new Course(this.description, this.majorId, this.instructor, this.time, this.date, room.getID(), this.capacity));
    }
    
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    public AdministrationService getAdministrationService() {
        return administrationService;
    }

    public void setAdministrationService(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    public Long getCourseID() {
        return courseID;
    }

    public void setCourseID(Long courseID) {
        this.courseID = courseID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
  
}
