package entities;

import enumerations.EAquisition;
import enumerations.ERole;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
    
    @Id
    @Column(name="Id")
    private Long ID;
    private Long userId;
    private String matrikelNumber;
    private String firstName;
    private String lastName;
    private Long addressId;
    private Major major;
    private EAquisition aquisition;
    private ERole eRole;

    public Student() {
    }

    public Student(Long ID, Long userId, String matrikelNumber, String firstName, String lastName, Long addressId, Major major, EAquisition aquisition, ERole eRole) {
        this.ID = ID;
        this.userId = userId;
        this.matrikelNumber = matrikelNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.major = major;
        this.aquisition = aquisition;
        this.eRole = eRole;
    }
    
    // Getter and setter
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMatrikelNumber() {
        return matrikelNumber;
    }

    public void setMatrikelNumber(String matrikelNumber) {
        this.matrikelNumber = matrikelNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public EAquisition getAquisition() {
        return aquisition;
    }

    public void setAquisition(EAquisition aquisition) {
        this.aquisition = aquisition;
    }

    public ERole geteRole() {
        return eRole;
    }

    public void seteRole(ERole eRole) {
        this.eRole = eRole;
    }
 
}
