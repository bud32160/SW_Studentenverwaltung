package entities;

import enumerations.ERoom;
import java.util.Date;
import java.util.List;

public class Course {
    
    private String ID;
    private String description;
    private String majorId;
    private String instructor;
    private String time;
    private Date date;
    private ERoom room;
    private List<String> participants;
    private int capacity;

    public Course() {
    }

    public Course(String ID, String description, String majorId, String instructor, String time, Date date, ERoom room, List<String> participants, int capacity) {
        this.ID = ID;
        this.description = description;
        this.majorId = majorId;
        this.instructor = instructor;
        this.time = time;
        this.date = date;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
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
