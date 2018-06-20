package entities;

import enumerations.EDay;
import enumerations.ETime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class Course implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    private String description;
    private Long majorId;
    private String instructor;
    private EDay eDay;
    private ETime eTime;
    private Long roomId;
    
    @ManyToMany(mappedBy="courseList")
    List<Student> participants;
    
    private int capacity;

    public Course() {
    }
    
    public Course(String description, Long majorId, String instructor, EDay day, ETime time, Long roomId, int capacity) {
        this.description = description;
        this.majorId = majorId;
        this.instructor = instructor;
        this.eDay = day;
        this.eTime = time;
        this.roomId = roomId;
        this.capacity = capacity;
    }

    public Course(Long ID, String description, Long majorId, String instructor, EDay day, ETime time, Long roomId, int capacity) {
        this.ID = ID;
        this.description = description;
        this.majorId = majorId;
        this.instructor = instructor;
        this.eDay = day;
        this.eTime = time;
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
