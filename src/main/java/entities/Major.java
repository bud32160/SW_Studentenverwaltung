package entities;

import enumerations.EAquisition;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major implements Serializable {
    
    @Id
    @Column(name="Id")
    private int ID;
    private String description;
    private EAquisition aquisition;

    public Major() {
    }

    public Major(int ID, String description, EAquisition aquisition) {
        this.ID = ID;
        this.description = description;
        this.aquisition = aquisition;
    }
    
    // Getter and setter

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EAquisition getAquisition() {
        return aquisition;
    }

    public void setAquisition(EAquisition aquisition) {
        this.aquisition = aquisition;
    }

}
