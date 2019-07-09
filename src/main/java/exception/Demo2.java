package exception;

public class Demo2 {
    public static void main(String[] args) {
        int []array=new int[1000];
        long start,end;
        start=System.currentTimeMillis();
        for (int i:array) {
            System.out.println(i);
        }
        end=System.currentTimeMillis();
        System.out.println("正常遍历所需时间："+(end-start));
        start=System.currentTimeMillis();
        try{
            int j=0;
            while(true){
                System.out.println(array[j++]);
            }
        }catch(Exception e){
            end=System.currentTimeMillis();
            System.out.println("异常遍历所需时间："+(end-start));
        }

    }
}
