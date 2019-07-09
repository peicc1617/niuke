package sort;

public class Test {
@org.junit.Test
    public void testInsert(){
        int array[]={3,2,1,5,6};
        System.out.println("排序前：");
        Util.printArray(array);
        InsertSort.insertSort(array);
        System.out.print("\n");
        System.out.println("排序后：");
        Util.printArray(array);
    }


}
