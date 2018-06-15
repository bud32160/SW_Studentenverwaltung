package enumerations;


public enum ETimeHandling {
    
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    SIXTH,
    SEVENTH;
    
    public String getAsString(){
        String time = null;
        
        switch(this){
            case FIRST :
                time = "08:15 - 09:45";
                break;
            case SECOND :
                time = "10:00 - 11:30";
                break;
            case THIRD :
                time = "11:45 - 13:15";
                break;
            case FOURTH :
                time = "13:30 - 15:00";
                break;
            case FIFTH :
                time = "15:15 - 16:45";
                break;
            case SIXTH :
                time = "17:00 - 18:30";
                break;
            case SEVENTH :
                time = "18:45 - 20:15";
                break;
        }
        
        return time;
    }
    
}


