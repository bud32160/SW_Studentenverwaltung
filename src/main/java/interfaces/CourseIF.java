package interfaces;

import entities.Course;
import entities.Student;

public interface CourseIF {
    
    public Course createCourse(Course course);
    
    public boolean deleteCourse(Course course);
    
    public Course updateCourse(Course course);
    
    public boolean signInCourse(Student student, Course course);
    
    public boolean signOutCourse(Student student, Course course);
}
