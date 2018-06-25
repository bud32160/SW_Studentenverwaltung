package models;

import converter.StudentConverter;
import entities.Course;
import entities.Exam;
import entities.Room;
import entities.Student;
import enumerations.EDay;
import enumerations.EMajor;
import enumerations.ETime;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import services.ExamService;
import services.RoomService;
import services.StudentService;

@Named
@SessionScoped
public class ExamModel implements Serializable {
    
    @Inject
    private ExamService examService;
    
    @Inject
    private RoomService roomService;
    
    @Inject
    private StudentService studentService;
    
    private Long examID;
    private Long courseId;
    private String time;
    private Date date;
    private String instructor;
    private Long roomId;
    private List<Student> participants;
    private int capacity;
    
    private Exam currentExam;
    private Student currentStudent;
    
    public void createExam(Exam exam){
        
        examService.createExam(exam);
    }
    
    public List<Exam> getAllExams(){
        FacesContext context = FacesContext.getCurrentInstance();
        List<Exam> list = examService.getAllExams();
        if(list == null){
            context.addMessage( null, new FacesMessage( "ERROR", "Keine Prüfungen vorhanden!" ));
            list = new ArrayList();
            return list;
        } else {
            return list;
        }
    }
    
    public String signInStudent(Student student, Exam exam){   
        this.currentStudent = student;
        this.currentExam = exam;
        
        FacesContext context = FacesContext.getCurrentInstance();
        boolean signedIn = examService.signInExam(this.currentStudent, this.currentExam);
        
        if(!signedIn){
            context.addMessage(null, new FacesMessage("Maximale Anzahl an Kursteilnehmern bereits erreicht!"));
            
            return "ExamOverview";
        } else {
            context.addMessage(null, new FacesMessage("Einschreibung erfolgreich!"));
            
            return "StudentExamView";
        }
    }
    
    public String signOutStudent(Student student, Exam exam){
        FacesContext context = FacesContext.getCurrentInstance();
        this.currentExam = exam;
        
        boolean signedOut = examService.signOutExam(this.currentStudent, this.currentExam);
        
        if(!signedOut){
            context.addMessage(null, new FacesMessage("Ausschreibung nicht möglich!"));
            
            return "StudentExamView";
        } else {
            context.addMessage(null, new FacesMessage("Ausschreibung erfolgreich!"));
            
            return "StudentExamView";
        }
    }

    public List<Exam> getCurrentExamList(Student student){
        Student s = studentService.getStudentByMailAddress(student.getMailAddress());
        List<Exam> examList = new ArrayList();
        
        if(s == null){
            return examList;
        }
        else{
            examList = s.getExamList();
            
            return examList;
        }
    }

    public Long getExamID() {
        return examID;
    }

    public void setExamID(Long examID) {
        this.examID = examID;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
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

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }

    public ExamService getExamService() {
        return examService;
    }

    public void setExamService(ExamService examService) {
        this.examService = examService;
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

    public Exam getCurrentExam() {
        return currentExam;
    }

    public void setCurrentExam(Exam currentExam) {
        this.currentExam = currentExam;
    }

}
