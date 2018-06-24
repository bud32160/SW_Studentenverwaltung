package enumerations;

public enum EMajor {
    IN,
    IT,
    IW,
    IM;
    
    @Override
    public String toString(){
        String result = "";
        
        switch(this){
            case IN :
                result = "Informatik";
                break;
            case IT :
                result = "Technische Informatik";
                break;
            case IW :
                result = "Wirtschaftsinformatik";
                break;
            case IM :
                result = "Medizininformatik";
                break;
        }
        
        return result;
    }
}
