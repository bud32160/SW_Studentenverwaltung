package entities;

import enumerations.EAquisition;
import enumerations.ERole;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
    
    @Id
    private String ID;
    private String userId;
    private String matrikelNumber;
    private String firstName;
    private String lastName;
    private Address address;
    private Major major;
    private EAquisition aquisition;
    private ERole eRole;

    public Student() {
    }

    public Student(String ID, String userId, String matrikelNumber, String firstName, String lastName, Address address, Major major, EAquisition aquisition, ERole eRole) {
        this.ID = ID;
        this.userId = userId;
        this.matrikelNumber = matrikelNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.major = major;
        this.aquisition = aquisition;
        this.eRole = eRole;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
