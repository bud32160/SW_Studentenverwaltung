package util;

import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


@Dependent
public class LoggerFactory{
    
    @Produces
    public Logger produceLogger(InjectionPoint ip){
        return Logger.getLogger(ip.getMember().getDeclaringClass().getCanonicalName());
    }
}


