package models;

import entities.Address;
import entities.Major;
import entities.Student;
import enumerations.EAquisition;
import enumerations.ERole;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.AdministrationService;

@Named
@SessionScoped
public class StudentModel implements Serializable {
    
    @Inject
    private AdministrationService administrationService;
    
    private int studentID;
    private String userId;
    private String matrikelNumber;
    private String firstName;
    private String lastName;
    private Major major;
    private EAquisition aquisition;
    private ERole eRole;
    
    private int addressID;
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;
    
    public void createStudent(){
    
        administrationService.createStudent(new Address(this.addressID, this.street, this.houseNumber, this.zipCode, this.city, this.country),
                new Student(this.studentID, this.userId, this.matrikelNumber, this.firstName, this.lastName, this.addressID, this.major, this.aquisition, this.eRole));
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
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

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
