package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class jdkInvocation implements InvocationHandler {
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("tagService代理前");
        Object returnObject=method.invoke(this.object,args);
        System.out.println("tagService代理后");
        if(method.getName().equals("readSomething")){
            System.out.println("区别对待");
            method.invoke(this.object,args);
        }
        return returnObject;
    }
}
