import java.util.*;
public class Main1{
    public static void main(String args[]){
        List result=new ArrayList();
        Scanner sc=new Scanner(System.in);
        int i=1;
        while(sc.hasNext()){
            int emptyBottle=sc.nextInt();
            if(emptyBottle==0) break;
            System.out.println(functionBottle(emptyBottle));
            result.add(functionBottle(emptyBottle));
                 if(i++>10) break;
        }
        printBottle(result);
    }

    public static  int functionBottle(int num){
        int finnalresult=0;
        if(num<=1||num>100)return 0;
        if(num==2) {
            return 1;
        }
        else{
            int a=num/3;//可直接兑换的汽水
            int b=num%3;//兑换后剩余的瓶子个数
            int c=a+b;//剩余瓶子的总个数
            finnalresult=a+functionBottle(c);
            return finnalresult;
        }

    }
    public static void printBottle(List list){
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i));

    }
}