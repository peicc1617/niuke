import java.io.File;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Example10_1 {
    public static void main(String args[]){
        File f=new File("E:\\peicc1413\\JAVA\\practice\\Example10_1","666.text");
        try {
            if (!f.exists()) {
                System.out.println("创建成功");
                f.createNewFile();
            }
        }
        catch(Exception e){

        }
        System.out.println(f.getName());
        System.out.println(f.isDirectory());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());
        f.mkdir();
        File f1=new File("E:\\peicc1413\\JAVA\\practice");
        String a[]=f1.list();
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
