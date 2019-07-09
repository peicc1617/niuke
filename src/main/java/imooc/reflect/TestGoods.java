package imooc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestGoods {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz=Class.forName("imooc.reflect.Goods");
        Constructor constructor1=clazz.getConstructor();
        Goods goods1=(Goods) constructor1.newInstance();
        goods1.display(goods1);
        Constructor constructor2=clazz.getConstructor(int.class,String.class,float.class,String.class);
        Goods goods2=(Goods) constructor2.newInstance(1,"香蕉",100,"这是香蕉");
        goods2.display(goods2);

    }

}
