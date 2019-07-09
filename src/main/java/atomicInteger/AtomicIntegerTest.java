package atomicInteger;

import java.util.concurrent.CountDownLatch;

public class AtomicIntegerTest {
    private static int ThREAD_COUNT=20;
    private static volatile int  count=0;
//    public static AtomicInteger count=new AtomicInteger(0);
    static CountDownLatch end=new CountDownLatch(ThREAD_COUNT);
    public static void increase(){
        count++;
//        count.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[ThREAD_COUNT];
        for(int i=0;i<ThREAD_COUNT;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <1000 ; j++) {
                        increase();
                        System.out.println("第"+count+"次调用");
                    }
                    end.countDown();

                }
            });
            threads[i].start();
        }
        end.await();
        System.out.println(count);
    }

}
