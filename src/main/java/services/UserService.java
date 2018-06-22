package services;

import entities.Student;
import entities.User;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;

@SessionScoped
public class AccountService implements Serializable {
    
   @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
   
   // Algorithm String for hash function
   private static final String algorithm = "SHA-256";
   
   @Inject
   private Logger logger;
   
   
    // Persists student object and creates automatically corresponding user object
    @Transactional
    public User signInStudent(Student student){
        // Create automatically email address for user object
        User user = student.getUser();
        user.setMailAddress(createMailAddress(student));
        
        // Check if student is already signed in with this mailAddress
        if(ceckIfNewAccount(user)){
            
            // Create cryptic password
            String salt = this.createRandomString(32);
            String password = this.saltAndHash(user.getPassword(), salt);
            user.setUsername(createUserName(student));
            user.setPassword(password);
            user.setSalt(salt);

            em.persist(student);
            em.persist(user);
        
            return user;
        }
        else{
            
            return null;
        }  
    }
    
    /**
     * Update a user
     * @param user
     * @return return 
     */
    @Transactional
    public User updateUser(User user) {

        user = em.merge(user);
        em.flush();
        logger.log(Level.INFO, "User updated: {0}", user.toString());
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
    
    private String createMailAddress(Student student) {
        String firstName = student.getFirstName().toLowerCase();
        String lastName = student.getLastName().toLowerCase();
        String ending = "@oth-regensburg.de";
        String matrNmbr = student.getMatrikelNumber();
        
        String result = firstName + "." + lastName + matrNmbr + ending;
        
        return result;     
    }

    private boolean ceckIfNewAccount(User user) {
        TypedQuery<User> query = em.createNamedQuery("User.VerificationOfExistence", User.class);
        query.setParameter("mailAddress", user.getMailAddress());
        
        return query.getResultList().isEmpty();
    }
    
    /**
     * Function to hash a passwort
     * @param password
     * @param salt
     * @return
     */
    public String saltAndHash(String password, String salt) {
        try {
            MessageDigest hashAlgo = MessageDigest.getInstance(algorithm);
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
