package models;

import converter.StudentConverter;
import entities.Course;
import entities.Exam;
import entities.Room;
import entities.Student;
import enumerations.EDay;
import enumerations.ETime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import services.CourseService;
import services.RoomService;
import services.StudentService;

@Named
@SessionScoped
public class CourseModel implements Serializable {
    
    @Inject
    private CourseService courseService;
    
    @Inject
    private RoomService roomService;
    
    @Inject
    private StudentService studentService;
    
    private Long courseID;
    private String description;
    private Long majorId;
    private String instructor;
    private EDay eDay;
    private ETime eTime;
    private Long roomId;
    private int capacity;
    private List<Student> participants;
    
    private Course currentCourse;
    private Student currentStudent;
    private Student participant;
    

    
    public void createCourse(Room room){
        this.participants = new ArrayList();
        
        Course course = new Course();
        courseService.createCourse(course);
    }
    
    public List<ETime> displayAvailableTimes(Room room, EDay day){
        FacesContext context = FacesContext.getCurrentInstance();
        List<ETime> list = courseService.getFreeTimeSlots(room, day);
        if(list == null){
            context.addMessage(null, new FacesMessage("Kursraum ausgebucht!"));
            return null;
        } else {
            return list;
        }
    }
    
    public List<Course> getAllCourse(){    
        FacesContext context = FacesContext.getCurrentInstance();
        List<Course> list = courseService.getAllCourse();
        if(list == null){
            context.addMessage(null, new FacesMessage("Kein Kurs vorhanden!"));
            list = new ArrayList();
            return list;
        } else {
            return list;
        }
    }
    
    public List<Course> getCurrentCourseList(Student student){
        Student s = studentService.getStudentByMailAddress(student.getMailAddress());
        List<Course> courseList = new ArrayList();
        
        if(s == null){
            return courseList;
        }
        else{
            courseList = s.getCourseList();
            
            return courseList;
        }
    }
    
    public String signInCourseStudent(Student student, Course course){   
        this.currentStudent = student;
        this.currentCourse = course;
        
        FacesContext context = FacesContext.getCurrentInstance();
        boolean signedIn = courseService.signInCourse(this.currentStudent, this.currentCourse);
        
        if(!signedIn){
            context.addMessage(null, new FacesMessage("Maximale Anzahl an Kursteilnehmern bereits erreicht!"));
            
            return "CourseOverview";
        } else {
            context.addMessage(null, new FacesMessage("Einschreibung erfolgreich!"));
            
            return "StudentCourseView";
        }
    }
    
    public String signOutCourseStudent(Student student, Course course){
        this.currentStudent = student;
        this.currentCourse = course;
        
        FacesContext context = FacesContext.getCurrentInstance();
        boolean signedOut = courseService.signOutCourse(this.currentStudent, course);
        
        if(!signedOut){
            context.addMessage(null, new FacesMessage("Ausschreibung nicht möglich!"));
            
            return "StudentCourseView";
        } else {
            context.addMessage(null, new FacesMessage("Ausschreibung erfolgreich!"));
            
            return "StudentCourseView";
        }
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

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public Student getParticipant() {
        return participant;
    }

    public void setParticipant(Student participant) {
        this.participant = participant;
    }

}
