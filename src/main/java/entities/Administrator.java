package entities;

import enumerations.ERole;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administrator implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    private String userId;
    private ERole role;
    
    public Administrator(){
        
    }

    public Administrator(Long ID, String userId, ERole role) {
        this.ID = ID;
        this.userId = userId;
        this.role = role;
    }
    
    // Getter and setter
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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
