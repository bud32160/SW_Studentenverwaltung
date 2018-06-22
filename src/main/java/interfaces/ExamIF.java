package interfaces;

import entities.Exam;
import entities.Student;

public interface ExamIF {
    
    public Exam createExam(Exam exam);
    
    public boolean deleteExam(Exam exam);
    
    public void signInExam(Student student, Exam exam);
    
    public void signOutExam(Student student, Exam exam);
}
