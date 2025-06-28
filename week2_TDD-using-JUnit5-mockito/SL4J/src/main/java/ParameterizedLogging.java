// Exercise 2: Parameterized Logging

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLogging {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLogging.class);

    public static void main(String[] args) {
        String username = "Prabyasachi";
        int loginAttempts = 3;

        logger.info("User {} has attempted to log in {} times.", username, loginAttempts);
    }
}