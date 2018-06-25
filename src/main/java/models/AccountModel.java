package models;

import controller.LogInController;
import entities.Address;
import entities.Course;
import entities.Exam;
import entities.Student;
import entities.User;
import enumerations.EAquisition;
import enumerations.EMajor;
import enumerations.ERole;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import services.UserService;
import services.StudentService;

@Named
@SessionScoped
public class AccountModel implements Serializable {
    
    @Inject
    private UserService accountService;
    
    @Inject
    private StudentService studentService;

    @Inject
    private LogInController logInController;
    
    private String username;
    private String password;
    private String mailAdress;
    private boolean logInStatus = false;
    
    private String firstName;
    private String lastName;
    private Date birthday;
    private EMajor major;
    private EAquisition aquisition;
    
    // private ERole roleModel;
    private User currentUser;
    private Student currentStudent;
    // private Professor currentProfessor;
    
    
    public String logIn(){
        FacesContext context = FacesContext.getCurrentInstance();
        this.currentUser = logInController.logIn(this.username, this.password);
        
        if(currentUser == null){
            context.addMessage( null, new FacesMessage( "Benutzername oder Passwort falsch" ));
            logInStatus = false;
            
            return "LogInView";
        }
        else{

            logInStatus = true;
            currentStudent = studentService.getStudentByUser(currentUser);
 
            return "WelcomeView";
        }
    }
   
    public String changeAddress(){
        
        Address address = new Address(this.currentStudent.getAddress().getStreet(), this.currentStudent.getAddress().getHouseNumber(),
                this.currentStudent.getAddress().getZipCode(), this.currentStudent.getAddress().getCity(), this.currentStudent.getAddress().getCountry());
        
        studentService.changeAddress(this.currentStudent, address);
        
        return "StudentOverview";
        
    }
    
    public String logOut(){	
        String result = logInController.logOut();
        this.currentUser = null;
        logInStatus = false;
        
        return result;
    }
    
    public boolean checkLogedInStudent(){
        ERole role = ERole.STUDENT;
        
        if(currentUser == null){
            return false;
        }
        
        return currentUser.getRoleModel().equals(role);
    }
    
    public boolean checkLogedInProfessor(){
        ERole role = ERole.PROFESSOR;
        
        if(currentUser == null){
            return false;
        }
        
        return currentUser.getRoleModel().equals(role);
    }
    
    /*
    
        public String getRoleModelToString(int count){
        String literal = "";
        switch(count){
            case 0 :
                literal =  ERole.STUDENT.toString();
                break;
            case 1 :
                literal = ERole.PROFESSOR.toString();
                break;
        }
        
        return literal;
    }
    
    public ERole returnRoleModel(int count){
        switch(count){
            case 0 :
                return ERole.STUDENT;
            case 1 :
                return ERole.PROFESSOR;
        }
        
        return null;
    }
    
    */
    

    
   public String registerSite(){
        String result = logInController.registerSite();
        this.currentUser = null;
        logInStatus = false;
        
        return result;
    }
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailAdress() {
        return mailAdress;
    }

    public void setMailAdress(String mailAdress) {
        this.mailAdress = mailAdress;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public UserService getAccountService() {
        return accountService;
    }

    public void setAccountService(UserService accountService) {
        this.accountService = accountService;
    }
    
    public LogInController getLogInController() {
        return logInController;
    }

    public void setLogInController(LogInController logInController) {
        this.logInController = logInController;
    }

    public boolean isLogInStatus() {
        return logInStatus;
    }

    public void setLogInStatus(boolean logInStatus) {
        this.logInStatus = logInStatus;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent) {
        this.currentStudent = currentStudent;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
 
}
