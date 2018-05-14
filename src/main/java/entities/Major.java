package entities;

import enumerations.EAquisition;

public class Major {
    
    private String ID;
    private String description;
    private EAquisition aquisition;

    public Major() {
    }

    public Major(String ID, String description, EAquisition aquisition) {
        this.ID = ID;
        this.description = description;
        this.aquisition = aquisition;
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

    public EAquisition getAquisition() {
        return aquisition;
    }

    public void setAquisition(EAquisition aquisition) {
        this.aquisition = aquisition;
    }

}
