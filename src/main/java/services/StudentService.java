package services;

import entities.Address;
import entities.Student;
import entities.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@WebService
@RequestScoped 
public class StudentService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    @Inject
    private UserService userService;
    
    /**
     * Creates and persists student and mapped user object
     * @param student
     * @param userPassword
     * @return
     */
    @WebMethod(exclude=true)
    @Transactional
    public Student createStudent(Student student, String userPassword){
        Student s = ceckIfAlreadyRegistered(student);
        if(s != null){
            return s;
        } 
        else {
            // Create automatically email address for student object
            student.setMailAddress(createMailAddress(student));
        
            User user = userService.createUserByStudent(student, userPassword);
        
            if(user == null){
                return null;
            }
            else {
                em.persist(student);
                em.persist(user);
                em.flush();
            
                return student;
            }
        }
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public Student updateStudent(Student student, Address address){
        em.persist(address);
        em.persist(student);
        em.flush();
        
        return student;
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public void deleteStudent(Student student, Address address){
        em.persist(address);
        em.persist(student);
        
    }
    
    public Student getStudentByUser(User user){
        
        Student student = em.find(Student.class, user.getMailAddress());
        
        return student;
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public void changeAddress(Student student, Address newAddress){
        
        Address address = em.find(Address.class, student.getId());
        
        em.getTransaction().begin();
        address.setStreet(newAddress.getStreet());
        address.setHouseNumber(newAddress.getHouseNumber());
        address.setCity(newAddress.getCity());
        address.setZipCode(newAddress.getZipCode());
        address.setCountry(newAddress.getCountry());
        em.getTransaction().commit();
    }

     /**
     * Creates mailAddress depending on mapped student object
     * @param user
     * @return
     */
    private String createMailAddress(Student student) {
        
        String firstName = student.getFirstName().toLowerCase();
        String lastName = student.getLastName().toLowerCase();
        String ending = "@oth-regensburg.de";
        String matrNmbr = student.getMatrikelNumber();
        
        String result = firstName + "." + lastName + matrNmbr + ending;
        
        return result;     
    }
    
    /**
     * Checks if student is already signed in
     * @param student
     * @return
     */
    private Student ceckIfAlreadyRegistered(Student student) {
        TypedQuery<Student> query = em.createNamedQuery("Student.getStudentByMailAddress", Student.class);
        query.setParameter("mailAddress", student.getMailAddress());
        
        if(query.getResultList().isEmpty()){
            return null;
        }
        else{
            return query.getSingleResult();
        }
    }
 
}
