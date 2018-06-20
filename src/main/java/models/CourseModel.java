package models;

import entities.Course;
import entities.Room;
import entities.Student;
import enumerations.EDay;
import enumerations.ETime;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.AdministrationService;
import services.CourseService;
import services.StudentService;

@Named
@SessionScoped
public class CourseModel implements Serializable {
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private StudentService studentService;
    
    @Inject
    private AdministrationService administrationService;
    
    private Long courseID;
    private String description;
    private Long majorId;
    private String instructor;
    private EDay eDay;
    private ETime eTime;
    private Long roomId;
    private int capacity;
    
    private Course currentCourse;
    private Student currentStudent;
    
    public void createCourse(Room room){
        
        administrationService.createCourse(new Course(this.description, this.majorId, this.instructor, this.eDay, this.eTime, room.getID(), this.capacity));
    }
    
    public List<ETime> displayAvailableTimes(Room room, EDay day){
        
        
        List<ETime> list = courseService.getFreeTimeSlots(room, day);
        
        return list;
    }
    
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }
    
    public void signInStudent(){
        
        studentService.signInCourse(this.currentStudent, this.courseID);
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

    public EDay geteDay() {
        return eDay;
    }

    public void seteDay(EDay eDay) {
        this.eDay = eDay;
    }

    public ETime geteTime() {
        return eTime;
    }

    public void seteTime(ETime eTime) {
        this.eTime = eTime;
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

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public Course getCurrentCourse() {
        return currentCourse;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }

}
