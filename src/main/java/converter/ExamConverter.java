package converter;

import entities.Exam;
import java.lang.annotation.Annotation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.Converter;
import services.ExamService;

@FacesConverter("converter.ExamConverter")
public class ExamConverter implements Converter {

    @Inject
    private ExamService examService;
    
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        if(value == null)
            return "";
        
        Exam exam = examService.getExamByDescription(value);
        if(exam == null)
            return "";
        
        return exam;
    }
    
    public String getAsString(FacesContext context, UIComponent component, Object value){
        if(value == null)
            return null;
        if(!value.getClass().equals(Exam.class))
            return null;
        
        return ((Exam)value).getDescription();
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
