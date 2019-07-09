package shejimoshi.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //Proxy类的getProxy方法入口，需要传入类加载器和接口
//        Class<?> proxyclass= Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(),HelloWorld.class);
//        final Constructor<?> cons=proxyclass.getConstructor(InvocationHandler.class);
//        final InvocationHandler ih=new MyInvocationHandler(new HelloWorldImpl());
//        HelloWorld helloWorld=(HelloWorld) cons.newInstance(ih);
//        helloWorld.sayHello();
        HelloWorld realObject=new HelloWorldImpl();
        HelloWorld proxy=(HelloWorld)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{HelloWorld.class},new MyInvocationHandler(realObject));
        proxy.sayHello();
    }
}
