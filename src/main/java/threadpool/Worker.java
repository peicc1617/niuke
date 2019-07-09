package threadpool;

public class Worker implements Runnable {
    private int i=0;

    public Worker(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("任务"+i+"被执行");
    }
}
