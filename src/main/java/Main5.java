import java.util.*;
public class Main5{
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int maxNum=1;
            int minNum=1;
            int mCount=1;
            int nCount=1;
            int num=sc.nextInt();
            int len=num;//数组长度
            int array[]=new int[num];
            int j=0;
            for(int i=0;i<len;i++){
                array[i] = sc.nextInt();
            }
            System.out.println("排序前：");
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            System.out.println();
            System.out.println("排序后：");
            Arrays.sort(array);
            for(int i=0;i<array.length;i++){
                System.out.print(array[i]+" ");
            }
            //相差最大，首尾元素相减
            int max=array[0]-array[len-1];
            //相差最小，相邻元素相减
            int min=Math.abs(array[0]-array[1]);//相差最小

            //首尾元素相等，则所有数据相等，最大最小均为Cn2
            if(max==0){
                maxNum=(len*len-1)/2;
                minNum=(len*len-1)/2;
            }
            else{
                //求解最大差
                for(int m=0,n=len-1;m<len-2&&n>=1;m++,n--){
                    if(array[m]==array[m+1])mCount++;
                    if(array[n]==array[n-1])nCount++;
                }
                maxNum=mCount*nCount;
                //求解最小差
                for(int m=0;m<len-1;m++){
                    if(Math.abs(array[m]-array[m+1])<min){
                        min=Math.abs(array[m]-array[m+1]);

                    }
                }
                for(int m=0;m<len-2;m++){
                    if(Math.abs(array[m]-array[m+1])==min){
                        minNum++;
                    }
                }
            }
            System.out.print(minNum+" "+maxNum);



        }


    }
}
