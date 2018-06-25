package converter;

import entities.Course;
import java.lang.annotation.Annotation;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.persistence.Converter;
import services.CourseService;

@FacesConverter("converter.CourseConverter")
public class CourseConverter implements Converter {
    
    @Inject
    private CourseService courseService;
    
    public Object getAsObject(FacesContext context, UIComponent component, String value){
        if(value == null)
            return "";
        
        Course course = courseService.getCourseByDescription(value);
        if(course == null)
            return "";
        
        return course;
    }
    
    public String getAsString(FacesContext context, UIComponent component, Object value){
        if(value == null)
            return null;
        if(!value.getClass().equals(Course.class))
            return null;
        
        return ((Course)value).getDescription();
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
