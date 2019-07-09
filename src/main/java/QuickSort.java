import java.util.Scanner;

public class QuickSort {
    public static void main(String args[]){
//        int array[]={6,1,2,7,9,3,4,5,10,8};
//        for(int i=0;i<array.length;i++)
//        System.out.print(array[i]+" ");
//        quickSort(array,0,array.length-1);
//        System.out.println();
//        for(int i=0;i<array.length;i++)
//            System.out.print(array[i]+" ");
        int array[];
        array=new int[1001];
        for(int i=0;i<=1000;i++){
            array[i]=0;
        }
        sort3(array);


    }
    public static  void quickSort(int a[],int left,int right){
        if(left>right)return;
        int temp=a[left];//定义基准函数
        int i=left;
        int j=right;

        while(i!=j){
            while(a[j]>=temp&i<j){
                j--;
            }
            while(a[i]<=temp&&i<j){
                i++;
            }

            if(i<j){
                int swap=a[i];
                a[i]=a[j];
                a[j]=swap;
            }
        }
        //基准数归位
        a[left]=a[i];
        a[i]=temp;
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);

    }
    public static void sort1(int array[]){


        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int temp=sc.nextInt();
            array[temp]=1;

        }
        for(int i=1;i<=1000;i++){
            if(array[i]==1){
                System.out.print(i+" ");

            }

        }
    }
    public static void sort2(int array[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int temp=sc.nextInt();
            array[i]=temp;

        }
        for(int i=0;i<num-1;i++){
            for(int j=0;j<num-1-i;j++){
            if(array[j]>array[j+1]){
                int tt=array[j];
                array[j]=array[j+1];
                array[j+1]=tt;


            }

            }

        }
        for(int i=0;i<num;i++){
            if(i!=0){
                if(array[i]!=array[i-1]){
                    System.out.println(array[i]);
                }
            }
            else{
                System.out.println(array[i]);
            }

        }

    }
    public static void sort3(int array[]){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        for(int i=0;i<num;i++){
            int temp=sc.nextInt();
            array[i]=temp;

        }
        int min=0;
        for(int i=0;i<num-1;i++){
            min=i;
            for(int j=i+1;j<=num-1;j++){
                if(array[j]<array[i]){
                    min=j;

                }

            }
            if(min!=i){
                int tt=array[i];
                array[i]=array[min];
                array[min]=tt;
            }

        }
        for(int i=0;i<=num-1;i++){
            System.out.print(array[i]+" ");

        }

    }
}
