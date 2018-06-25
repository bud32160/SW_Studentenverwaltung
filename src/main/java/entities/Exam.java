package entities;

import enumerations.EDay;
import enumerations.ETime;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import util.SingleIdEntity;

@Entity
@Table(name="EXAM_TABLE")
@NamedQueries({
    @NamedQuery(name="Exam.getAllExams", query="SELECT e FROM Exam AS e"),
    @NamedQuery(name = "Exam.getExamByDescription", query = "SELECT e FROM Exam AS e WHERE e.description = :description" )
})
public class Exam extends SingleIdEntity implements Serializable {

    @Column(name="CoursId")
    private Long courseId;
    
    @Column(name="Date")
    private Date date;
    
    @Column(name="Description")
    private String description;
    
    @Column(name="Instructor")
    private String instructor;
    
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

    public Exam() {
    }

    public Exam(Long id, Long courseId, Date date, String description, String instructor, Room room, List<Student> participants, int capacity) {
        this.setManualId(id);
        this.courseId = courseId;
        this.date = date;
        this.instructor = instructor;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String dateToString(){
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy");
        
        return df.format(this.date);
    }
    
    public String timeToString(){
        SimpleDateFormat df = new SimpleDateFormat("H:mm");
        
        return df.format(this.date);
    }
    
    public String dateFormatted(){
        return (dateToString() + " - " + timeToString());
    }
    
}
