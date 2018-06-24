package enumerations;

public enum ERole {
    
    STUDENT,
    PROFESSOR;
    
    @Override
    public String toString(){
        String result = "";
        
        switch(this){
            case STUDENT :
                result = "Student";
                break;
            case PROFESSOR :
                result = "Professor";
                break;
        }
        
        return result;
    }
}
