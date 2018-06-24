package enumerations;


public enum ETime {
    
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    SIXTH,
    SEVENTH;
    
    @Override
    public String toString(){
        String result = "";
        
        switch(this){
            case FIRST :
                result = "08:15 - 09:45";
                break;
            case SECOND :
                result = "10:00 - 11:30";
                break;
            case THIRD :
                result = "11:45 - 13:15";
                break;
            case FOURTH :
                result = "13:30 - 15:00";
                break;
            case FIFTH :
                result = "15:15 - 16:45";
                break;
            case SIXTH :
                result = "17:00 - 18:30";
                break;
            case SEVENTH :
                result = "18:45 - 20:15";
                break;
        }
        
        return result;
    }
    
}


