package enumerations;

public enum ERoomDescriptor {
    
    A,
    D,
    E,
    K;
    
    @Override
    public String toString(){
        String result = "";
        
        switch(this){
            case A :
                result = "A";
                break;
            case D :
                result = "B";
                break;
            case E :
                result = "E";
                break;
            case K :
                result = "K";
                break;
        }
        
        return result;
    }
}
