package models;

import entities.Room;
import enumerations.ERoomDescriptor;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.RoomService;

@Named
@SessionScoped
public class RoomModel implements Serializable {
    
    @Inject
    private RoomService roomService;
    
    private Long ID;
    private ERoomDescriptor descriptor;
    private String number;
    private int capacity;
    
    public void createRoom(){
        
        //TODO : Create enum ERoomDescriptor
        
        roomService.createRoom(new Room(this.descriptor, this.number, this.capacity));
    }

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
