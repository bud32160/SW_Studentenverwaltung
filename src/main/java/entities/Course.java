package entities;

import enumerations.EDay;
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
import javax.persistence.NamedQuery;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import util.SingleIdEntity;

@Entity
@NamedQuery(name="Course.getAllCourse", query="SELECT c FROM Course AS c")
public class Course extends SingleIdEntity implements Serializable {
    
    @Column(name="Description")
    private String description;
    
    @Column(name="MajorId")
    private int majorId;
    
    @Column(name="Instructor")
    private String instructor;
    
    @Column(name="EDay")
    private EDay eDay;
    
    @Column(name="ETime")
    private ETime eTime;
    
    @Column(name="RoomId")
    private int roomId;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Students")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> participants;
    
    @Column(name="Capacity")
    private int capacity;

    public Course() {
    }

    public Course(String description, int majorId, String instructor, EDay eDay, ETime eTime, int roomId, List<Student> participants, int capacity) {
        this.description = description;
        this.majorId = majorId;
        this.instructor = instructor;
        this.eDay = eDay;
        this.eTime = eTime;
        this.roomId = roomId;
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

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
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

    public int getRoom() {
        return roomId;
    }

    public void setRoom(int roomId) {
        this.roomId = roomId;
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
