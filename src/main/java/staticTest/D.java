package staticTest;

import java.util.Date;

public class D extends Date {
    public static void main(String[] args) {
        long start=0,end=0;
        StringBuilder sb=new StringBuilder();
        start=System.currentTimeMillis();
        for (int i = 0; i <1000 ; i++) {
            sb.append(i);
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("创建的StringBuilder对象为："+sb+"耗时："+(end-start));
        String str=new String();
        start=System.currentTimeMillis();
        for (int i = 0; i <1000 ; i++) {
            str=str+i;
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("创建的String对象为："+str+"耗时："+(end-start));
    }

}
