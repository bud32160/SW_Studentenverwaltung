package interfaces;

import entities.Student;
import entities.User;

public interface UserIF {
    
    public User createUserByStudent(Student student, String userPassword);
    
    public User findUserByMailAddress(User user);
    
    public User findUserByStudent(Student student);
    
    public User updateUser(User user);
    
    
}
