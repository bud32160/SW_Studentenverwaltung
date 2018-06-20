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
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Exam implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    private Long courseId;
    private String time;
    private Date date;
    private String instructor;
    private Long roomId;
    
    @ManyToMany(mappedBy="examList")
    List<Student> participants;
    
    private int capacity;

    public Exam() {
    }

    public Exam(Long ID, Long courseId, String time, Date date, String instructor, Long roomId, int capacity) {
        this.ID = ID;
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
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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
    
    @XmlTransient
    public List<Student> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public void setKandidaten(List<Student> participants) {
        this.participants = participants;
    }
  
}
