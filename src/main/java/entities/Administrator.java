package entities;

import enumerations.ERole;

public class Administrator {
    
    private String ID;
    private String userId;
    private ERole role;
    
    public Administrator(){
        
    }

    public Administrator(String ID, String userId, ERole role) {
        this.ID = ID;
        this.userId = userId;
        this.role = role;
    }
    
    // Getter and setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

}