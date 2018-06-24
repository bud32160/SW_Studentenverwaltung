package enumerations;

public enum EDay {
    
    MO,
    TU,
    WED,
    TH,
    FR,
    SA;
    
    @Override
    public String toString(){
        String result = "";
        
        switch(this){
            case MO :
                result = "Montag";
                break;
            case TU :
                result = "Dienstag";
                break;
            case WED :
                result = "Mittwoch";
                break;
            case TH :
                result = "Donnerstag";
                break;
            case FR :
                result = "Freitag";
                break;
            case SA :
                result = "Samstag";
                break;
        }
        
        return result;
    }
   
}
