package entities;

import enumerations.ERoom;
import java.util.Date;
import java.util.List;

public class Exam {
    
    private String ID;
    private String courseId;
    private String time;
    private Date date;
    private String instructor;
    private ERoom room;
    private List<String> participants;
    private int capacity;

    public Exam() {
    }

    public Exam(String ID, String courseId, String time, Date date, String instructor, ERoom room, List<String> participants, int capacity) {
        this.ID = ID;
        this.courseId = courseId;
        this.time = time;
        this.date = date;
        this.instructor = instructor;
        this.room = room;
        this.participants = participants;
        this.capacity = capacity;
    }
    
    // Getter and setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
  
}