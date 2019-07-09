import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static  void main(String[]args){

        String answer[]={"南非","巴西进入了世界杯","中国进个几把"};
        ServerSocket socketForClient=null;
        Socket socketOnServer=null;
        DataOutputStream out;
        DataInputStream in;
        try{
            socketForClient=new ServerSocket(2010);
            socketOnServer=socketForClient.accept();//建立连接
            out=new DataOutputStream(socketOnServer.getOutputStream());
            in=new DataInputStream(socketOnServer.getInputStream());
//            String s=in.readUTF();
            while(true){
                String s=in.readUTF();
                System.out.println("收到客户端的提问："+s);
            }

//            for(int i=0;i<answer.length;i++){
//                String s=in.readUTF();
//                System.out.println("收到客户端的提问："+s);
//                out.writeUTF(answer[i]);
//                Thread.sleep(2000);
//            }

        }
        catch(Exception e){
            System.out.println("客户已断开");
        }
    }
}
