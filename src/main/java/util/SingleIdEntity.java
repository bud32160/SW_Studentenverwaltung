package util;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

    
@MappedSuperclass
public abstract class SingleIdEntity {
    
    @Id
    @Column(name="Table_Id")
    private Long id;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(){
        // Create Long id number
        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
    
