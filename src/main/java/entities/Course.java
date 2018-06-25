package entities;

import enumerations.EDay;
import enumerations.EMajor;
import enumerations.ETime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import util.SingleIdEntity;

@Entity
@Table(name="COURSE_TABLE")
@NamedQueries({
    @NamedQuery(name="Course.getAllCourse", query="SELECT c FROM Course AS c"),
    @NamedQuery(name = "Course.getCourseByDescription", query = "SELECT c FROM Course AS c WHERE c.description = :description" )
})

public class Course extends SingleIdEntity implements Serializable {
    
    @Column(name="Description")
    private String description;
    
    @Column(name="ExamId")
    private Long examId;
    
    @Column(name="Major")
    private EMajor major;
    
    @Column(name= "Instructor")
    private String instructor;
    
    @Column(name="EDay")
    private EDay eDay;
    
    @Column(name="ETime")
    private ETime eTime;
    
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "Room")
    private Room room;
    
    @ManyToMany
    @JoinColumn(name = "Students")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> participants;
    
    @Column(name="Capacity")
    private int capacity;

    public Course() {
    }

    public Course(String description, Long examId, EMajor major, String instructor, EDay eDay, ETime eTime, Room room, List<Student> participants, int capacity) {
        this.description = description;
        this.examId = examId;
        this.major = major;
        this.instructor = instructor;
        this.eDay = eDay;
        this.eTime = eTime;
        this.room = room;
        this.participants = participants;
        this.capacity = capacity;
    }
    
    public Course(Long id, String description, Long examId, EMajor major, String instructor, EDay eDay, ETime eTime, Room room, List<Student> participants, int capacity) {
        this.setManualId(id);
        this.examId = examId;
        this.description = description;
        this.major = major;
        this.instructor = instructor;
        this.eDay = eDay;
        this.eTime = eTime;
        this.room = room;
        this.participants = participants;
        this.capacity = capacity;
    }
    
    
    
    public void addParticipant(Student student){
        if(this.participants==null)
            this.participants = new ArrayList<>();
        if(!this.participants.contains(student))
            this.participants.add(student);
    }

    // Getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public EMajor getMajor() {
        return major;
    }

    public void setMajor(EMajor major) {
        this.major = major;
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public EDay getEDay() {
        return eDay;
    }

    public void setEDay(EDay eDay) {
        this.eDay = eDay;
    }

    public ETime getETime() {
        return eTime;
    }

    public void setETime(ETime eTime) {
        this.eTime = eTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
  
}
