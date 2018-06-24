package services;

import entities.Student;
import entities.User;
import enumerations.ERole;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SessionScoped
public class UserService implements Serializable {
    
   @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
   
   // Algorithm String for hash function
   private static final String ALGORITHM = "SHA-256";
   
   @Inject
   private Logger logger;
   
   @Inject
   private StudentService studentService;
   
   /**
     * Creates user object depending on mapped student
     * @param student
     * @param userPassword
     * @return
     */
   public User createUserByStudent(Student student, String userPassword){
        ERole role = ERole.STUDENT;
        User user = new User();
        user.setId();
        
        // Create cryptic password
        String salt = this.createRandomString(32);
        String password = this.saltAndHash(userPassword, salt);
        user.setPassword(password);
        user.setSalt(salt);
        
        user.setMailAddress(student.getMailAddress());
        user.setUsername(createUserNameStudent(student));
        user.setRoleId(student.getId());
        user.setRole(role);
        
        em.persist(user);
        em.flush();
        
        return user;
   }
   
    public User findUserByMailAddress(User user){
        User u = em.find(User.class, user.getId());
        if(u == null){
            logger.log(Level.INFO, "User does not exist");
            return null;
        }

        return u;
    }
    
    /**
     * Find a user by student
     * @param student
     * @return
     */
    public User findUserByStudent(Student student){
        User u = em.find(User.class, student.getUserId());
        if(u == null){
            logger.log(Level.INFO, "User does not exist");
            return null;
        }

        return u;
    }
    
    @Transactional
    public User updateUser(User user) {

        user = em.merge(user);
        em.flush();
        return user;
    }

    /**
     * Creates the username depending on the mapped student object
     * @param student
     * @return
     */
    private String createUserNameStudent(Student student) {
        char[] firstName = student.getFirstName().toCharArray();
        char[] lastName = student.getLastName().toCharArray();
        
        // Create first part of username (first three letters of first and last name)
        char[] userName = new char[3];
        userName[0] = lastName[0];
        userName[1] = lastName[1];
        userName[2] = firstName[0];
        
        String s1 = new String(userName);
        String result = s1.toLowerCase();
        
        return (result + student.getMatrikelNumber());
    }
    
    /**
     * Function to hash a passwort
     * @param password
     * @param salt
     * @return
     */
    public String saltAndHash(String password, String salt) {
        try {
            MessageDigest hashAlgo = MessageDigest.getInstance(ALGORITHM);
            String toHash = salt + "#" + password;
            byte[] output = hashAlgo.digest(toHash.getBytes("UTF-8"));
            StringBuilder passwordBuilder = new StringBuilder();
            for(byte b : output)
                passwordBuilder.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            return passwordBuilder.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            throw new RuntimeException("Could not hash password", ex);
        }
    }
    
    /**
     * Function to create the salt for the passwordhash
     * @param byteLength
     * @return
     */
    public String createRandomString(int byteLength) {
        SecureRandom zufallsgenerator = new SecureRandom();
        byte[] bytes = new byte[byteLength];
        zufallsgenerator.nextBytes(bytes);
        BigInteger zufallszahl = new BigInteger(bytes);
        return zufallszahl.abs().toString(32).toUpperCase();
    }
    
}
