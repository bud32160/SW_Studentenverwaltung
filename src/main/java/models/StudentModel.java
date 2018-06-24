package models;

import entities.Address;
import enumerations.EMajor;
import entities.Student;
import entities.User;
import enumerations.EAquisition;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import othr.sw.payfast.service.PayementServiceService;
import othr.sw.payfast.service.Transaction;
import services.UserService;
import services.StudentService;

@Named
@SessionScoped
public class StudentModel implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/im-lamport_8080/PayFast-1.0-/PayementService.wsdl")
    private PayementServiceService service;
    
    @Inject
    private AccountModel accountModel;
    
    @Inject
    private StudentService studentService;
    
    @Inject
    private UserService userService;
    
    @Inject
    private UserService accountService;
    
    private String mailAddress;
    private String matrikelNumber;
    private String firstName;
    private String lastName;
    private Date birthday;
    private EMajor major;
    private EAquisition aquisition;
    
    private String password;
    
    private String street;
    private String houseNumber;
    private String zipCode;
    private String city;
    private String country;
    
    private Student currentStudent;
    private User registratedUser;
    private String mailFromStudent;
    private XMLGregorianCalendar confirmationPayedDate;
    
    public String createStudent(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        Address address = new Address(this.street, this.houseNumber, this.zipCode, this.city, this.country);
        Student student = new Student(this.firstName, this.lastName, address, this.birthday, this.major, this.aquisition);
        
        Student s = studentService.createStudent(student, this.password);
        
        if(s == null){
            
            context.addMessage( null, new FacesMessage( "ERROR", "Dieser Student ist bereits registriert!" ));
            return "RegistrationFail";
        }
        else {
            this.registratedUser = userService.findUserByStudent(s);
            
            return "RegistrationSuccess";
        }
        
    }


    /**
     * Creates transaction to pay confirmation
     * @return
     */
    public String doTransaction(){
        FacesContext context = FacesContext.getCurrentInstance();
        Transaction transaction = studentService.payConfirmation(this.mailFromStudent, this.currentStudent);
        
        if(transaction == null){
            context.addMessage( null, new FacesMessage( "ERROR", "Rückmeldung fehlgeschlagen!" ));
            
            return "ConfirmationView";
        }
        else{
            this.currentStudent.setConfirmationPayed(true);
            this.confirmationPayedDate = transaction.getDone();
            
            return "ConfirmationView";
        }

    }
    
    public String getMajorString(int count){
        String literal = "";
        switch(count){
            case 0 :
                literal =  EMajor.IN.toString();
                break;
            case 1 :
                literal = EMajor.IT.toString();
                break;
            case 2 :
                literal = EMajor.IW.toString();
                break;
            case 3 :
                literal = EMajor.IM.toString();
                break;
        }
        
        return literal;
    }
    
    public String getAquisitionString(int count){
        String literal = "";
        switch(count){
            case 0 :
                literal =  EAquisition.BACHELOR.toString();
                break;
            case 1 :
                literal = EAquisition.MASTER.toString();
                break;
        }
        
        return literal;
    }
    
    public EMajor returnMajor(int count){
        switch(count){
            case 0 :
                return EMajor.IN;
            case 1 :
                return EMajor.IT;
            case 2 :
                return EMajor.IW;
            case 3 :
                return EMajor.IM;
        }
        
        return null;
    }
    
    public EAquisition returnAquisition(int count){
        switch(count){
            case 0 :
                return EAquisition.BACHELOR;
            case 1 :
                return EAquisition.BACHELOR;
        }
        
        return null;
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

    public EMajor getMajor() {
        return major;
    }

    public void setMajor(EMajor major) {
        this.major = major;
    }

    public EAquisition getAquisition() {
        return aquisition;
    }

    public void setAquisition(EAquisition aquisition) {
        this.aquisition = aquisition;
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

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public User getRegistratedUser() {
        return registratedUser;
    }

    public void setRegistratedUser(User registratedUser) {
        this.registratedUser = registratedUser;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getAccountService() {
        return accountService;
    }

    public void setAccountService(UserService accountService) {
        this.accountService = accountService;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailFromStudent() {
        return mailFromStudent;
    }

    public void setMailFromStudent(String mailFromStudent) {
        this.mailFromStudent = mailFromStudent;
    }

    public PayementServiceService getService() {
        return service;
    }

    public void setService(PayementServiceService service) {
        this.service = service;
    }

    public XMLGregorianCalendar getConfirmationPayedDate() {
        return confirmationPayedDate;
    }

    public void setConfirmationPayedDate(XMLGregorianCalendar confirmationPayedDate) {
        this.confirmationPayedDate = confirmationPayedDate;
    }
   
}
