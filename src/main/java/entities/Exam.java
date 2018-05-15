package entities;

import enumerations.ERoom;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exam implements Serializable {
    
    @Id
    @Column(name="Id")
    private int ID;
    private String courseId;
    private String time;
    private Date date;
    private String instructor;
    private ERoom room;
    // private List<String> participants;
    private int capacity;

    public Exam() {
    }

    public Exam(int ID, String courseId, String time, Date date, String instructor, ERoom room, int capacity) {
        this.ID = ID;
        this.courseId = courseId;
        this.time = time;
        this.date = date;
        this.instructor = instructor;
        this.room = room;
        this.capacity = capacity;
    }
    
    // Getter and setter
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
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

    public ERoom getRoom() {
        return room;
    }

    public void setRoom(ERoom room) {
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
  
}
