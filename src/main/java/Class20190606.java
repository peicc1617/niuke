import java.util.concurrent.locks.ReentrantLock;

public class Class20190606 {

   static ReentrantLock lock=new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
    }
}