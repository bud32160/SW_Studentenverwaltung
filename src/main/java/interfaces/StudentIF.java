package interfaces;

import entities.Address;
import entities.Student;
import entities.User;

public interface StudentIF {
    
    public Student createStudent(Student student, String userPassword);
    
    public Student updateStudent(Student student, Address address);
    
    public void deleteStudent(Student student, Address address);
    
    public void changeAddress(Student student, Address newAddress);
    
    public Student getStudentByUser(User user);
    
}
