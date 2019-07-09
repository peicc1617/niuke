public class Synchronise {
    public synchronized void function1(){
        System.out.println("输出");
    }
    public static void main(String[] args){
      Synchronise a=  new Synchronise();
      a.function1();
    }
}
