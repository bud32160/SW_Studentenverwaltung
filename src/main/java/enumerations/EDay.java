package enumerations;

public enum EDay {
    
    MO,
    TU,
    WED,
    TH,
    FR,
    SA;
    
    public String getAsString(){
        String day = null;
        
        switch(this){
            case MO :
                day = "Montag";
                break;
            case TU :
                day = "Dienstag";
                break;
            case WED :
                day = "Mittwoch";
                break;
            case TH :
                day = "Donnerstag";
                break;
            case FR :
                day = "Freitag";
                break;
            case SA :
                day = "Samstag";
                break;
        }
        
        return day;
    }
   
}
