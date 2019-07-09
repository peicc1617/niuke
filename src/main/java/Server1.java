import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static  void main(String[]args){

        ServerSocket socketForClient=null;
        Socket socketOnServer=null;
        DataOutputStream out;
        DataInputStream in;
        try{
            socketForClient=new ServerSocket(2010);
            socketOnServer=socketForClient.accept();//建立连接
            out=new DataOutputStream(socketOnServer.getOutputStream());
            in=new DataInputStream(socketOnServer.getInputStream());
            double r=in.readDouble();
            System.out.println("收到客户端请求");
            double area=Math.PI*r*r;
            out.writeDouble(area);

        }
        catch(Exception e){
            System.out.println("客户已断开");
        }
    }
}
