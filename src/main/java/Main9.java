import java.math.BigInteger;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String num1=sc.next();
        String num2=sc.next();
        System.out.println(multipy(num1,num2));

    }
    public static String multipy(String num1,String num2){
        char array1[]=num1.toCharArray();
        char array2[]=num2.toCharArray();
        int len=array1.length+array2.length;
        int result[]=new int[len];
        for(int i=array2.length-1;i>-1;i--){
            for(int j=array1.length-1;j>-1;j--){
                result[len-2-i-j]+=(array2[i]-'0')*(array1[j]-'0');
            }
        }
        for(int i=0;i<len-1;i++){
            if(result[i]>9){
                int temp=result[i]/10;
                result[i]=result[i]%10;
                result[i+1]+=temp;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=len-1;i>-1;i--){
            if(i==len-1&&result[i]==0){
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
