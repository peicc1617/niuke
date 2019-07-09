import java.util.*;
public class Main3{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int result=0;
            String orign=sc.nextLine();
            String temp=orign.substring(2);
            int len=temp.length();
            for(int i=0;i<len;i++){
                int a=mapFunction(temp.charAt(i));
                result=result+a*(int)Math.pow(16,len-i-1);

            }
            System.out.println(result);

        }

    }
    private static int mapFunction(char c ){
        if(c<65) {
            return c-'0';
        }
        else{
            return c-65+10;
        }

    }
}
