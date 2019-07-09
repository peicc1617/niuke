package shejimoshi.waiguanmoshi.children;

import org.apache.log4j.Logger;

public class CPU {
    public static final Logger LOGGER=Logger.getLogger(CPU.class);
    public void start(){
        LOGGER.info("cpu is start...");
    }
    public void shutDown(){
        LOGGER.info("cpu is shutdown...");
    }
}
