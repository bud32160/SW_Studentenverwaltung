package entities;

import enumerations.ERoomDescriptor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import util.SingleIdEntity;

@Entity
@Table(name="ROOM_TABLE")
public class Room extends SingleIdEntity implements Serializable{
    
    @Column(name="Descriptor")
    private ERoomDescriptor descriptor;
    
    @Column(name="Number")
    private String number;
    
    @Column(name="Capacity")
    private int capacity;

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
   
}
