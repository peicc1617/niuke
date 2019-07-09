package proxy;

import java.lang.reflect.Proxy;

public class Start {
    public static void main(String[] args) {
        jdkInvocation invocation=new jdkInvocation();
        invocation.setObject(new tagServiceImpl());
        tagService service= (tagService) Proxy.newProxyInstance(Start.class.getClassLoader(),new Class[]{tagService.class},invocation);
        service.printSomething();
        service.readSomething();
    }
}
