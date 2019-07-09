import java.math.BigInteger;
import java.util.*;
public class Main8{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList list=new ArrayList();
        int count=0;
        count=sc.nextInt();
        for(int i=0;i<count;i++){
            list.add(sc.nextBigInteger());
        }
        Collections.sort(list);
        System.out.println(list);
        if(count==3){
            System.out.println(((BigInteger)list.get(0)).multiply((BigInteger)list.get(1)).multiply((BigInteger)list.get(2)));
            return;
        }
        if(count<3){
            throw new IllegalArgumentException();
        }else{
            BigInteger max1=((BigInteger)list.get(0)).multiply((BigInteger)list.get(1)).multiply((BigInteger)list.get(count-1));
            BigInteger max2=((BigInteger)list.get(count-1)).multiply((BigInteger)list.get(count-2)).multiply((BigInteger)list.get(count-3));
            System.out.println(max1.compareTo(max2)==1?max1:max2);
        }

    }
}