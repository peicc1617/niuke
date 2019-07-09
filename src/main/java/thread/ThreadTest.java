package thread;

import javax.management.relation.RoleUnresolved;
import java.util.LinkedList;

public class ThreadTest {
    boolean flag=true;
    static LinkedList list=new LinkedList();

    public static void main(String[] args) {
        Thread thread1=new Thread(new Thread1(),"1");
        Thread thread2=new Thread(new Thread2(),"2");
        thread1.start();
        thread2.start();
    }
    static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (list){
                System.out.println("即将中断线程1");
                try {
                    System.out.println("下一步中断");
                    list.wait();
                    System.out.println("线程1成功唤醒");
                }
                catch (InterruptedException e) {
                    System.out.println("中断唤醒");
                    e.printStackTrace();
                }
            }
        }
    }
    static class Thread2 implements Runnable{
        @Override
        public void run() {
            System.out.println("进入线程2");
            synchronized (list){
                System.out.println("中断唤醒线程1");
                list.notify();
            }
        }
    }
}
