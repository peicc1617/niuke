package proxy;

public class tagServiceImpl implements tagService {
    @Override
    public void printSomething() {
        System.out.println("实现了接口中的打印方法");
    }

    @Override
    public void readSomething() {
        System.out.println("实现了接口中的读方法");
    }
}
