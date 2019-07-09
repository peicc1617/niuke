import java.util.Scanner;

public class Solution1 {
    public static void main(String args[]){
        int temp=0;
        Solution1 aa=new Solution1();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            temp=sc.nextInt();
            System.out.print(aa.NumberOf1Between1AndN_Solution(temp)+" "+aa.NumberOf1Between1AndN_Solution1(temp));
            System.out.println();
        }


    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n==0)return 0;
        if(n>0&&n<10) return 1;
        return NumberOf1Between1AndN_Solution(n-1)+NumberOfN_Solution(n);//递归容易溢出
    }
    public int NumberOfN_Solution(int n){
        int result=0;
        while(n>=1){
            int a=n%10;
            n=n/10;
            if(a==1)
                result++;
        }
        return result;
    }
    public int NumberOf1Between1AndN_Solution1(int n) {
        int count=0;
        while(n>0){
            String str=String.valueOf(n);
            char [] chars=str.toCharArray();
            for(int i=0;i<chars.length;i++){
                if(chars[i]=='1')
                    count++;
            }
            n--;
        }
        return count;
    }
}
