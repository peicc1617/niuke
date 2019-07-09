package shejimoshi.waiguanmoshi.children;

import org.apache.log4j.Logger;

public class Disk {
    public static final Logger LOGGER=Logger.getLogger(Disk.class);
    public void start(){
        LOGGER.info("Disk is start...");
    }
    public void shutDown(){
        LOGGER.info("Disk is shutdown...");
    }
}
