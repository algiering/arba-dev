package java22.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {
    private static Logger log = LoggerFactory.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        
        log.info("hello~!");
        
        if (log.isDebugEnabled()) {
            log.debug("hello~!");
        }

    }

}
