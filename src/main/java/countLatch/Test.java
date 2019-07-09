package countLatch;

import java.util.concurrent.CountDownLatch;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(new Worker(countDownLatch,i)).start();
        }
        countDownLatch.await();
        System.out.println("所有子线程结束之后");
    }
    static class Worker implements Runnable{
        private CountDownLatch countDownLatch;
        private int i;

        public Worker(CountDownLatch countDownLatch, int i) {
            this.countDownLatch = countDownLatch;
            this.i = i;
        }

        @Override
        public void run() {
            doWork();
        }
        private void doWork(){
            System.out.println("创建子线程，子线程的ID为"+i);
            try {
                Thread.sleep(5000);
                System.out.println("创建子线程，子线程的ID为"+i+"休眠结束");
                countDownLatch.countDown();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
