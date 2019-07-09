package niukejianshu;

import java.util.Currency;

public class ErWeiShuZuChaZhao {
    public static void main(String[] args) {
        int [][] array=new int[1000][1000];
        int p=0;
        for(int i=0; i < array.length; ++i)
            for(int j=0; j<array[i].length; ++j)
                array[i][j] =++p ;
        long starttime=System.currentTimeMillis();
        System.out.println(find1(array,50000));
        long endtime=System.currentTimeMillis();
        System.out.println("所需时间为："+(endtime-starttime));
        starttime=System.currentTimeMillis();
        System.out.println(find2(array,5000));
         endtime=System.currentTimeMillis();
        System.out.println(endtime-starttime);
    }
    public static boolean find1(int [][] array,int target){
        if(array==null){
            return false;
        }
        int row=0;
        int col=array[0].length-1;
        while(row<array.length&&col>=0){
            if(target==array[row][col]){
                return true;
            }else if(target<array[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
    public static boolean find2(int [][] array,int target){
        if(array==null){
            return false;
        }
        int row=0;
        int col=array[0].length-1;
        while(row<array.length&&col>=0){
            if(target==array[row][col]){
                return true;
            }else if(target<array[row][col]){
                int start=0,end=0,middle=0;
                int count=0;//比较次数
                end=array[0].length;
                middle=(start+end)/2;
                while(target!=array[row][middle]){
                    if(target>array[row][middle]){
                        start=middle;
                    }else{
                        end=middle;
                    }
                    middle=(start+end)/2;
                    count++;
                    if(count>array[0].length/2){
                        return false;
                    }
                }
                return true;
            }else{
                row++;
            }
        }
        return false;
    }
}
