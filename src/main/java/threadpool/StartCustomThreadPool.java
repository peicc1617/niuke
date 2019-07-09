package threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class StartCustomThreadPool {
    private final static Logger LOGGER= LoggerFactory.getLogger(CustomThreadPool.class);
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue=new ArrayBlockingQueue(4);
        CustomThreadPool pool=new CustomThreadPool(3, 5, 1, TimeUnit.SECONDS, queue, new Notify() {
            public void notifyListen() {
                System.out.println("任务执行完毕");
            }
        });
        System.out.println("添加任务前任务队列的当前任务数："+queue.size());
        //添加十个任务
        for(int i=0;i<10;i++){
            pool.execute(new Worker(i));
        }
        System.out.println("添加任务后任务队列的当前任务数："+queue.size());
        System.out.println("***********休眠前线程池活跃数********："+pool.getWorkerCount());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("***********休眠后线程池活跃数********："+pool.getWorkerCount());
        for (int i = 0; i <3 ; i++) {
            pool.execute(new Worker(i+100));
        }
        pool.shutdown();
        System.out.println("*********************");
        pool.mainNotify();
    }
}
