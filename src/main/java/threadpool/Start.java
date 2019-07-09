package threadpool;

import java.io.IOException;

//测试：ab -c5000 -n5000 127.0.0.1:8080/Index.html
public class Start {
    public static void main(String[] args) {
        System.out.println("启动服务器");
        SimpleHttpServer simpleHttpServer=new SimpleHttpServer();
        simpleHttpServer.setBasePath("E:\\peicc1413\\JAVA\\practice\\niuke\\src\\threadpool");
        try {
            simpleHttpServer.start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
