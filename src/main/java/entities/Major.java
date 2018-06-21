package entities;

import enumerations.EAquisition;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import util.SingleIdEntity;

@Entity
@Table(name="MAJOR_TABLE")
public class Major extends SingleIdEntity implements Serializable {
    
    @Column(name="Description")
    private String description;
    
    @Column(name="Aquisition")
    private EAquisition aquisition;

    public Major() {
    }

    public Major(String description, EAquisition aquisition) {
        this.description = description;
        this.aquisition = aquisition;
    }
    
    // Getter and setter

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
