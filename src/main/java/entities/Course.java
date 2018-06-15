package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    private String description;
    private Long majorId;
    private String instructor;
    private String time;
    private Date date;
    private int roomId;
    // private List<String> participants;
    private int capacity;

    public Course() {
    }

    public Course(Long ID, String description, Long majorId, String instructor, String time, Date date, int roomId, int capacity) {
        this.ID = ID;
        this.description = description;
        this.majorId = majorId;
        this.instructor = instructor;
        this.time = time;
        this.date = date;
        this.roomId = roomId;
        this.capacity = capacity;
    }

    // Getter and setter
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
   
}
