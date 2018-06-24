package entities;

import enumerations.ERoomDescriptor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import util.SingleIdEntity;

@Entity
@Table(name="ROOM_TABLE")
@NamedQuery(name="Room.getAllRooms", query="SELECT r FROM Room AS r")
public class Room extends SingleIdEntity implements Serializable{
    
    @Column(name="Descriptor")
    private ERoomDescriptor descriptor;
    
    @Column(name="Number")
    private String number;
    
    @Column(name="Capacity")
    private int capacity;
    
   @OneToMany(mappedBy="room", cascade = CascadeType.ALL )
   @LazyCollection(LazyCollectionOption.FALSE ) 
   private List<Course> courseList;
    
   @OneToMany(mappedBy="room", cascade = CascadeType.ALL )
   @LazyCollection(LazyCollectionOption.FALSE) 
   private List<Exam> examList;

    public Room() {
        
    }
    
    public Room(ERoomDescriptor descriptor, String number, int capacity) {
        this.descriptor = descriptor;
        this.number = number;
        this.capacity = capacity;
    }
    
    // Getter and setter
    public ERoomDescriptor getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(ERoomDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }
    
}
