package shejimoshi.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理类扩展逻辑
        System.out.println("mehtod:"+method.getName()+" is inviked!");
        return method.invoke(target,args);
    }
}
