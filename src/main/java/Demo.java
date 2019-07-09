public class Demo { class Super{ private  int flag=1;
    Super(){

        test();
    }  void test(){
        System.out.println("Super.test() flag="+flag);
    }
} class Sub extends Super{
    int flag;
    Sub(int i){
        System.out.println("Sub.Sub()flag="+i);
    }  void test(){
        System.out.println("Sub.test()flag="+flag);
    }
}  public static void main(String[] args) {  new Demo().new Sub(5);
}
}
