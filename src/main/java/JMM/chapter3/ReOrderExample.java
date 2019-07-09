package JMM.chapter3;

public class ReOrderExample {
    int a=0;
    boolean flag=false;
    public void writer(){
        System.out.println("进入写操作");
        flag=true;
        a=1;
        System.out.println("退出写操作");
    }
    public void reader(){
        System.out.println("进入读操作");
        if(flag){
            int i=a*a;
            System.out.println("执行读操作，结果为："+i);
        }
        System.out.println("退出读操作");
    }
}
