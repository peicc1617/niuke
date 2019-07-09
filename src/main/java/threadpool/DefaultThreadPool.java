package threadpool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable>implements ThreadPool<Job> {
    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS=10;
    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS=5;
    //线程池最小的数量
    private static final int MIN_WORKER_NUMBERS=1;
    //保存工作（Job）的工作列表
    private final LinkedList<Job> jobs=new LinkedList<Job>();
    //工作者（线程）列表
    private final List<Worker> workers= Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程池的数量
    private int workerNum=DEFAULT_WORKER_NUMBERS;
    //线程编号
    private AtomicLong threadNum=new AtomicLong();
    //无参构造函数
    public DefaultThreadPool() {
        //初始化工作者线程
        initializeWorkers(workerNum);
    }
    //有参构造函数
    public DefaultThreadPool(int num){
        workerNum=num>MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initializeWorkers(workerNum);
    }
    private void initializeWorkers(int num){
        for (int i = 0; i <num ; i++) {
            Worker worker=new Worker();
            workers.add(worker);
            Thread thread=new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }

    /**
     * 执行一个job
     * @param job
     */
    @Override
    public void execute(Job job) {
        if(job!=null){
            synchronized (jobs){
                jobs.add(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker:workers){
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        //新增的worker数量不能超过最大值
        if(num+this.workerNum>MAX_WORKER_NUMBERS){
            num=MAX_WORKER_NUMBERS-this.workerNum;
        }
        initializeWorkers(num);
        this.workerNum+=num;
    }

    @Override
    public void removeWorkers(int num) {
        synchronized (jobs){
            if(num>=this.workerNum){
                throw new IllegalArgumentException("超出已有线程数量");
            }
            //按照给定数量停止Worker
            int count=0;
            while(count<num){
                Worker worker=workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum-=count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }
    //从工作队列中取出工作执行
    class Worker implements Runnable{
        //是否工作
        private volatile boolean running=true;
        @Override
        public void run() {
            while (running){
                Job job=null;
                synchronized (jobs){
                    while(jobs.isEmpty()){
                        try {
                            jobs.wait();
                        }
                        catch (InterruptedException e) {
                            //感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();

                            e.printStackTrace();
                            return;
                        }
                    }
                    job=jobs.removeFirst();
                }
                if(job!=null){
                    job.run();
                }
            }
        }
        public void shutdown(){
            running=false;
        }
    }
}
