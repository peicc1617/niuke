import java.util.*;
public class Main2{
    public static void main(String args[]){
        boolean isFirstNumber=true;//判断是否是输入的第一个数
        int count=1;//输入数据的总个数
        int array[]=new int[1001];
        Scanner sc=new Scanner(System.in);
        while(count>0&&sc.hasNext()){
            if(isFirstNumber){
                count=sc.nextInt();
                isFirstNumber=false;//置否
            }
            else{
                int a=sc.nextInt();
                array[a]=1;
                count--;
            }

        }
        for(int i=1;i<1001;i++){
            if(array[i]==1){
                System.out.println(i);
            }

        }
    }
}