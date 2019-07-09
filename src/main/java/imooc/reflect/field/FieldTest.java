package imooc.reflect.field;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest  {
    @Test
    public void demo() /*throws Exception*/{
        try {
            Class clazz=Class.forName("imooc.reflect.field.Person");
            Field field=clazz.getDeclaredField("sex");
            field.setAccessible(true);
            Person p=(Person)clazz.newInstance();
            field.set(p,"男");
            Object obj=field.get(p);
            System.out.println(obj);
            System.out.println(p);

        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
