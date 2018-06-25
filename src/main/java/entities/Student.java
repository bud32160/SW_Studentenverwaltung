package entities;

import enumerations.EAquisition;
import enumerations.EMajor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import util.SingleIdEntity;

@Entity
@Table(name="STUDENT_TABLE")
@NamedQueries({
@NamedQuery(name = "Student.getAllStudents", query = "SELECT s FROM Student AS s"),
@NamedQuery(name = "Student.getStudentByMatrikelnumber", query = "SELECT s FROM Student AS s WHERE s.matrikelNumber = :matrikelNumber" ),
@NamedQuery(name = "Student.getStudentByMailAddress", query = "SELECT s FROM Student AS s WHERE s.mailAddress = :mailAddress" ),
})
public class Student extends SingleIdEntity implements Serializable {
    
    @Column(name="Student_MailAddress")
    private String mailAddress;
    
    @Column(name="User_Id")
    private Long userId;
    
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
    private EMajor major;
    
    @Column(name="Aquisition")
    private EAquisition aquisition;
    
    @Column(name="Confirmation_Payed")
    private boolean confirmationPayed;
    
    @ManyToMany
    @JoinColumn(name="Courses")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Course> courseList;
    
    @ManyToMany
    @JoinColumn(name="Exams")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Exam> examList;

    public Student() {
    }

    public Student(String firstName, String lastName, Address address, Date birthday, EMajor major, EAquisition aquisition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.major = major;
        this.aquisition = aquisition;
    }

    public Student(Long userId, String matrikelNumber, String firstName, String lastName, Address address, Date birthday, EMajor major, EAquisition aquisition) {
        this.matrikelNumber = matrikelNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.major = major;
        this.aquisition = aquisition;
        this.userId = userId;
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
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
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

    public boolean isConfirmationPayed() {
        return confirmationPayed;
    }

    public void setConfirmationPayed(boolean confirmationPayed) {
        this.confirmationPayed = confirmationPayed;
    }

    @Override
    public String toString() {
        return "Student{" + "mailAddress=" + mailAddress + ", matrikelNumber=" + matrikelNumber + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
}
