package JMM.chapter3;

public class ReOrderExampleTest {
    static ReOrderExample reOrderExample;

    public static void main(String[] args) {
        reOrderExample=new ReOrderExample();
        Thread thread1=new Thread(new Runnable() {
            public void run() {
                reOrderExample.writer();
            }
        },"写线程");
        Thread thread2=new Thread(new Runnable() {
            public void run() {
                reOrderExample.reader();
            }
        },"读线程");
        thread1.start();
        thread2.start();
        System.out.println("执行完毕");
    }

}
