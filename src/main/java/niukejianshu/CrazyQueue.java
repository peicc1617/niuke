package niukejianshu;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

//疯狂队列，求解队列差值最大化
public class CrazyQueue {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int len=sc.nextInt();
            int nums[]=new int[len];
            for(int i=0;i<len;i++){
                nums[i]=sc.nextInt();
            }
            ArrayDeque result=new ArrayDeque();
            Arrays.sort(nums);
            int max=nums[len-1];//疯狂队列中的最大值
            int min=nums[0];//疯狂队列中的最小值
            int distance=max-min;
            result.addFirst(max);
            result.addLast(min);
            int minIndex=1;//未加入疯狂队列的最小值索引
            int maxIndex=len-2;
            int i=1;//第几次加入疯狂队列
            while(minIndex<maxIndex){
                i++;
                distance+=max-nums[minIndex];
                distance+=nums[maxIndex]-min;
                if((i&1)==0){
                    result.addFirst(nums[minIndex]);
                    result.addLast(nums[maxIndex]);

                }else{
                    result.addFirst(nums[maxIndex]);
                    result.addLast(nums[minIndex]);

                }
                min=nums[minIndex++];
                max=nums[maxIndex--];
            }
            //原数组最后一个元素minIndex==maxIndex
            //加入疯狂队列左边
            int a=Math.abs(((int)result.getFirst()-nums[maxIndex]));
             int b=Math.abs(((int)result.getLast()-nums[maxIndex]));
             if(a>b){
                 result.addFirst(nums[maxIndex]);
             }else{
                 result.addLast(nums[maxIndex]);
             }
            //加入疯狂队列右边
            distance+=Math.max(nums[maxIndex]-min,max-nums[minIndex]);
            System.out.println(distance);
            System.out.println(result);
        }
    }
}
