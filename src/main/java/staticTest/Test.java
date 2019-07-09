package staticTest;

import java.io.FileOutputStream;

public class Test {
    public static void main(String[] args) {

       A a=new A();
       a.normalName="A类的noamalName属性";
       B b=new B();
       b.normalName="B类的noamalName属性";
        System.out.println(a.normalName);
        System.out.println(b.normalName);
        A a1=new B();
        System.out.println(a1.normalName);
        a.staticName="A类的staticName属性";
        b.staticName="B类的staticName属性";
        System.out.println(a.staticName);
        System.out.println(b.staticName);
//        A.inneeC c=new A.inneeC();


    }
}
