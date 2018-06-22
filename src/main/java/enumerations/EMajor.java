package enumerations;

public enum EMajor {
    IN,
    IT,
    IW,
    IM;
    
    @Override
    public String toString(){
        String literal = null;
        
        switch(this){
            case IN :
                literal = "Informatik";
                break;
            case IT :
                literal = "Technische Informatik";
                break;
            case IW :
                literal = "Wirtschaftsinformatik";
                break;
            case IM :
                literal = "Medizininformatik";
                break;
        }
        
        return literal;
    }
}
