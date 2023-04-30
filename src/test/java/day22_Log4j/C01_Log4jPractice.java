package day22_Log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4jPractice {
    @Test
    public void log4j() {
        Logger logger = LogManager.getLogger(C01_Log4jPractice.class);
        logger.info("info");
        logger.warn("warn");
        logger.fatal("fatal");
        logger.debug("debug");
        logger.error("error");
    }
}
