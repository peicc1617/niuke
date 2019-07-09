package sort;

public class InsertSort {
    public static void insertSort(int[] array){
        int len=array.length;
        for(int i=1;i<len-1;i++){
           int j=i-1;
           int temp=array[i];
           while(j>=0){
               if(array[j+1]<array[j]){
                    swap(array,j,j+1);
                    j--;
               }else{
                   break;
               }
           }
        }
    }
    //交换数组两元素位置
    public static void swap(int array[],int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    //插入排序
    public static void InsertSort(int []array){
        int len=array.length;
        //从第二个元素开始，共需要n-1趟排序
        for(int i=1;i<len;i++){
            int temp=array[i];//待排序的元素
            int j=i;//记录应该插入的位置
            while(j>0&&temp<array[j-1]){
                //当待排序元素比已排序元素小时，已排序元素后退一位
                array[j]=array[j-1];
                j--;//已排序元素向前一位
            }
            array[j]=temp;//将待排序元素插入到正确位置
        }
    }
}
