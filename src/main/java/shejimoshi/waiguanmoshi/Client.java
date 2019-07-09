package shejimoshi.waiguanmoshi;

import org.apache.log4j.Logger;
import shejimoshi.waiguanmoshi.facade.Computer;

public class Client {
    public static final Logger LOGGER = Logger.getLogger(Client.class);
    public static void main(String[] args)
    {
        Computer computer = new Computer();
        computer.start();
        LOGGER.info("=================");
        computer.shutDown();
        System.out.println("客户类");
    }
}
