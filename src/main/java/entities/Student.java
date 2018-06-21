package entities;

import enumerations.EAquisition;
import enumerations.ERole;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import util.SingleIdEntity;

@Entity
@Table(name="STUDENT_TABLE")
@NamedQuery(name = "Student.VerificationOfExistence", query = "SELECT s FROM Student AS s WHERE s.mailAddress = :mailAddress" )
public class Student extends SingleIdEntity implements Serializable {
    
    @Column(name="MatrikelNumber")
    private String matrikelNumber;
    
    @Column(name="FirstName")
    private String firstName;
    
    @Column(name="LastName")
    private String lastName;
    
    @Embedded
    private Address address ;
    
    @Column(name="Birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Column(name="Major")
    private Major major;
    
    @Column(name="Aquisition")
    private EAquisition aquisition;
    
    @Column(name="ERole")
    private ERole eRole;
    
    @MapsId
    @OneToOne(mappedBy="student")
    @JoinColumn(name="Student_Id")
    private User user;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Courses")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Course> courseList;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Exams")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Exam> examList;

    public Student() {
    }

    public Student(String matrikelNumber, String firstName, String lastName, Address address, Date birthday, Major major, EAquisition aquisition, ERole eRole, User user) {
        this.matrikelNumber = matrikelNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.major = major;
        this.aquisition = aquisition;
        this.eRole = eRole;
        this.user = user;
    }

    public void addCourse(Course course){
        if(this.courseList == null)
            this.courseList = new ArrayList<>();
        if(!this.courseList.contains(course))
            this.courseList.add(course);
    }
    
    public void addExam(Exam exam){
        if(this.examList == null)
            this.examList = new ArrayList<>();
        if(!this.examList.contains(exam))
            this.examList.add(exam);
    }
    
    // Getter and setter
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

}
