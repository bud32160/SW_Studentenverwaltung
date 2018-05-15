package models;

import entities.Room;
import enumerations.ERoomDescriptor;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.AdministrationService;

@Named
@SessionScoped
public class RoomModel implements Serializable {
    
    @Inject
    private AdministrationService administrationService;
    
    private int ID;
    private ERoomDescriptor descriptor;
    private String number;
    private int capacity;
    
    public void createRoom(){
        
        //TODO : Create enum ERoomDescriptor
        
        administrationService.createRoom(new Room(this.ID, this.descriptor, this.number, this.capacity));
    }

    public AdministrationService getAdministrationService() {
        return administrationService;
    }

    public void setAdministrationService(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
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
