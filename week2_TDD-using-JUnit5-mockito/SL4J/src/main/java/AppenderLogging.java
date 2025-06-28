// Exercise 3: Using Different Appenders

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLogging {
    private static final Logger logger = LoggerFactory.getLogger(AppenderLogging.class);

    public static void main(String[] args) {
        logger.debug("This is a debug message");
        logger.info("This message goes to both console and file");
        logger.error("This is an error message for troubleshooting");
    }
}