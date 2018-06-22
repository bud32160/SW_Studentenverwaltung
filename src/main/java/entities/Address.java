package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable {
    
    @Column(name="Street")
    private String street;
    
    @Column(name="HouseNumber")
    private String houseNumber;
    
    @Column(name="ZipCode")
    private String zipCode;
    
    @Column(name="City")
    private String city;
    
    @Column(name="Country")
    private String country;

    public Address() {
    }

    public Address(String street, String houseNumber, String zipCode, String city, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }
    
    // Getter and Setter
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
