package imooc.reflect.field;

public class Person {
    private String sex;
    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
