package converter;

import entities.Student;
import java.lang.annotation.Annotation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.Converter;
import services.StudentService;

@FacesConverter("converter.StudentConverter")
public class StudentConverter implements Converter {
    
    @Inject
    private StudentService studentService;
    
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        if(value == null)
            return "";
        
        Student student = studentService.getStudentByMailAddress(value);
        if(student == null)
            return "";
        
        return student;
    }
    
    public String getAsString(FacesContext context, UIComponent component, Object value){
        if(value == null)
            return null;
        if(!value.getClass().equals(Student.class))
            return null;
        
        return ((Student)value).getMailAddress();
    }

    @Override
    public boolean autoApply() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
