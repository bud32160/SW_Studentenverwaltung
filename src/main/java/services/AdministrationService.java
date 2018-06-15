package services;

import entities.Address;
import entities.Course;
import entities.Exam;
import entities.Room;
import entities.Student;
import entities.User;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@RequestScoped
public class AdministrationService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    @Transactional
    public void createStudent(Student student, Address address){
        User user = createUserObject(student);
        
        em.persist(user);
        em.persist(address);
        em.persist(student);
    }
    
    @Transactional
    public void createCourse(Course course){
        em.persist(course);
    }
    
    @Transactional
    public void createRoom(Room room){
        em.persist(room);
    }
    
    @Transactional
    public void createExam(Exam exam){
        em.persist(exam);
    }

    private User createUserObject(Student student) {
        User user = new User();
        
        user.setUserName(createUserName(student));
        user.setPassword(createUserPassword());
        user.setRoleUserId(student.getID());
        user.setMailAddress(createUserMailAddress(student));
        user.setID(createUserId());
        
        return user;
    }

    private String createUserName(Student student) {
        char[] firstName = student.getFirstName().toCharArray();
        char[] lastName = student.getLastName().toCharArray();
        
        // Create first part of username (first three letters of first and last name)
        char[] userName = new char[3];
        userName[0] = lastName[0];
        userName[1] = lastName[1];
        userName[2] = firstName[0];
        
        String s1 = new String(userName);
        String result = s1.toLowerCase();
        
        // Concatenate with random number (between 30000 and 40000)
        Random random = new Random();
        int value = 30000 + random.nextInt(1000);
        String s2 = Integer.toString(value);
        
        return (result + s2);
    }

    private String createUserPassword() {
        Random random = new Random();
        int value = 10000 + random.nextInt(100000);
        String result = Integer.toString(value);
        
        return result;
    }

    private String createUserMailAddress(Student student) {
        String firstName = student.getFirstName().toLowerCase();
        String lastName = student.getLastName().toLowerCase();
        String ending = "@oth-regensburg.de";
        String matrNmbr = student.getMatrikelNumber();
        
        String result = firstName + "." + lastName + matrNmbr + ending;
        
        return result;     
    }

    private Long createUserId() {
        boolean idIsUnique = false;
        Long id = createIdNumber();
        
        // Check if Id is already used
        while(!idIsUnique){
            String selectCommand = "SELECT u FROM USER AS u WHERE id = " + id;
            TypedQuery<User> query = em.createQuery(selectCommand, User.class);
        
            List<User> userList = query.getResultList();
            if(userList.size() > 0){
                id = createIdNumber();
            }
            else{
                idIsUnique = true;
            }
        }
        
        return id;
    }
    
    private Long createIdNumber(){
        
        // Create random value for id
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
  
}
