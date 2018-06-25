package services;

import entities.Address;
import entities.Student;
import entities.User;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.xml.ws.WebServiceRef;
import othr.sw.payfast.service.Account;
import othr.sw.payfast.service.PayementServiceService;
import othr.sw.payfast.service.Transaction;

@WebService
@RequestScoped 
public class StudentService {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/im-lamport_8080/PayFast-1.0-/PayementService.wsdl")
    private PayementServiceService service;
    
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
        
        student.setMailAddress(createMailAddress(student));
        
        Student s = ceckIfAlreadyRegistered(student);
        if(s != null){
            return null;
        } 
        else {
            student.setId();                    
            student.setMatrikelNumber(createMatrikelNumber());
            student.setConfirmationPayed(false);
            
            User user = userService.createUserByStudent(student, userPassword);
        
            if(user == null){
                return null;
            }
            else {
                student.setUserId(user.getId());
                
                em.persist(student);
                em.flush();
            
                return student;
            }
        }
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public List<Student> getAllStudents(){
        TypedQuery<Student> query = em.createNamedQuery("Student.getAllStudents", Student.class);
        
        return query.getResultList();
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public Transaction payConfirmation(String mailFrom, Student student){

        try { // Call Web Service Operation
            othr.sw.payfast.service.PayementService port = service.getPayementServicePort();
            // TODO initialize WS operation arguments here
            
            Account accountTo = new Account();
            accountTo.setIdEmail("verwaltung@oth-regensburg.de");
            Account accountFrom = new Account();
            accountFrom.setIdEmail(mailFrom);
            
            Long amount = 130L;
            String description = "Rückmeldung Student: " + student.getFirstName() + " " + student.getLastName();
            
            
            
            othr.sw.payfast.service.Transaction arg0 = new othr.sw.payfast.service.Transaction();
            arg0.setAmount(amount);
            arg0.setDescription(description);
            arg0.setFrom(accountFrom);
            arg0.setTo(accountTo);
            // TODO process result here
            othr.sw.payfast.service.Transaction result = port.createTransaction(arg0);
            
            return result;
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            return null;
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
        em.flush();
        
    }
    
    public Student getStudentByUser(User user){
        
        try{
            TypedQuery<Student> query = em.createNamedQuery("Student.getStudentByMailAddress", Student.class);
            query.setParameter("mailAddress", user.getMailAddress());
        
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }        
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public Student getStudentByMailAddress(String mailAddress){
        
        try{
            TypedQuery<Student> query = em.createNamedQuery("Student.getStudentByMailAddress", Student.class);
            query.setParameter("mailAddress", mailAddress);
            
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }        
    }
    
    @WebMethod(exclude=true)
    @Transactional
    public void changeAddress(Student student, Address newAddress){
        Student s = em.find(Student.class, student.getId());
        
        s.getAddress().setStreet(newAddress.getStreet());
        s.getAddress().setHouseNumber(newAddress.getHouseNumber());
        s.getAddress().setCity(newAddress.getCity());
        s.getAddress().setZipCode(newAddress.getZipCode());
        s.getAddress().setCountry(newAddress.getCountry());
        em.merge(s);
        em.flush();
        
    }

     /**
     * Creates mailAddress depending on mapped student object
     * @param student
     * @return
     */
    private String createMailAddress(Student student) {
        
        String firstName = student.getFirstName().toLowerCase();
        String lastName = student.getLastName().toLowerCase();
        String ending = "@oth-regensburg.de";
        
        String result = firstName + "." + lastName + ending;
        
        return result;     
    }
    
    /**
     * Creates matrikelNumber for student object
     * @return
     */
    private String createMatrikelNumber() {
     
        String matrikelNumber;
        
        Random random = new Random();
        int x = random.nextInt(10000) + 30000;
        matrikelNumber = Integer.toString(x);
        
        return matrikelNumber;     
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
