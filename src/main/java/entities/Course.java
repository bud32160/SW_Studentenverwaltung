package entities;

import enumerations.EDay;
import enumerations.ETime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@XmlRootElement
public class Course implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    
    @Column(name="Description")
    private String description;
    
    @Column(name="MajorId")
    private Long majorId;
    
    @Column(name="Instructor")
    private String instructor;
    
    @Column(name="EDay")
    private EDay eDay;
    
    @Column(name="ETime")
    private ETime eTime;
    
    @ManyToOne( cascade = CascadeType.PERSIST)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "Course_Room")
    private Room room;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Students")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Student> participants;
    
    @Column(name="Capacity")
    private int capacity;

    public Course() {
    }

    public Course(Long ID, String description, Long majorId, String instructor, EDay eDay, ETime eTime, Room room, List<Student> participants, int capacity) {
        this.ID = ID;
        this.description = description;
        this.majorId = majorId;
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
