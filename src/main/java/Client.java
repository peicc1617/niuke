import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String[] mesage ={"2010世界杯在哪里举办？","巴西进入世界杯了吗？","中国进入世界杯了吗？"};
        Socket mysocket;
        DataInputStream in=null;
        DataOutputStream out=null;
        try {
            mysocket=new Socket("127.0.0.1",2010);
            in = new DataInputStream(mysocket.getInputStream());
            out=new DataOutputStream(mysocket.getOutputStream());
            for(int i=0;i<mesage.length;i++){
                out.writeUTF(mesage[i]);
                String s=in.readUTF();//读取信息，阻塞状态
                System.out.println("收到服务器的回答"+s);
                Thread.sleep(2000);
            }
        }
        catch(Exception e){
            System.out.println("服务器已断开");
        }
    }
}
