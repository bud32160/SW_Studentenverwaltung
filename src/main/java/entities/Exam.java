package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlTransient;
import util.SingleIdEntity;

@Entity
@NamedQuery(name="Exam.getAllExams", query="SELECT e FROM Exam AS e")
public class Exam extends SingleIdEntity implements Serializable {

    @Column(name="CourseId")
    private int courseId;
    
    @Column(name="Time")
    private String time;
    
    @Column(name="Date")
    private Date date;
    
    @Column(name="Instructor")
    private String instructor;
    
    @Column(name="RoomId")
    private Long roomId;
    
    @Column(name="Participants")
    @ManyToMany(mappedBy="examList")
    List<Student> participants;
    
    @Column(name="Capacity")
    private int capacity;

    public Exam() {
    }

    public Exam(int courseId, String time, Date date, String instructor, Long roomId, int capacity) {
        this.courseId = courseId;
        this.time = time;
        this.date = date;
        this.instructor = instructor;
        this.roomId = roomId;
        this.capacity = capacity;
    }
    
    public void addParticipant(Student student){
        if(this.participants==null)
            this.participants = new ArrayList<>();
        if(!this.participants.contains(student))
            this.participants.add(student);
    }
    
    // Getter and setter
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
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
    
    @XmlTransient
    public List<Student> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public void setKandidaten(List<Student> participants) {
        this.participants = participants;
    }
  
}
