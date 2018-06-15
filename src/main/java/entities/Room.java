package entities;

import enumerations.ERoomDescriptor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room implements Serializable{
    
    @Id
    @Column(name="Id")
    private Long ID;
    private ERoomDescriptor descriptor;
    private String number;
    private int capacity;

    public Room() {
        
    }
    
    public Room(ERoomDescriptor descriptor, String number, int capacity) {
        this.descriptor = descriptor;
        this.number = number;
        this.capacity = capacity;
    }

    public Room(Long ID, ERoomDescriptor descriptor, String number, int capacity) {
        this.ID = ID;
        this.descriptor = descriptor;
        this.number = number;
        this.capacity = capacity;
    }
    
    // Getter and setter
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

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
   
}
