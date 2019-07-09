package niukejianshu;
import java.util.*;
public class Reverse{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        String orign[]=new String[len];
        for(int i=0;i<len;i++){
            orign[i]=String.valueOf(sc.next());
        }
        StringBuilder temp=new StringBuilder();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<len;i++){
            temp.append(orign[i]);
            temp=temp.reverse();
        }
        for(int i=0;i<len;i++){
            if(i==len-1){
                result.append(temp.substring(i,i+1));
            }else{
                result.append(temp.substring(i,i+1)+" ");
            }

        }
        System.out.println(result.toString());
    }
    /*
    public StringBuilder reverse(StringBuilder origin){
        int len=origin.length();
    }
    */
}