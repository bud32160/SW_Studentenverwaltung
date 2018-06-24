package enumerations;

public enum EAquisition {
    
    BACHELOR,
    MASTER;
    
    @Override
    public String toString(){
        String result = "";
        
        switch(this){
            case BACHELOR :
                result = "Bachelor";
                break;
            case MASTER :
                result = "Master";
                break;
        }
        
        return result;
    }
    
}
