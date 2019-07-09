package thread;

public class ThreadSafe {
    private static int count=0;
    private static final int THREAD_COUNT=10;
    private synchronized static void getCount(){
        count++;
        System.out.println("已调用"+count+"次");
    }

    public static void main(String[] args) {
        for(int i=0;i<THREAD_COUNT;i++){
            Thread thread=new Thread(new Runnable(){
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        getCount();
                    }

                }
            });
            thread.start();
        }
    }

}
