package niukejianshu;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {
    static TreeSet<Person> ts=new TreeSet<Person>();

    public static void main(String[] args) {
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));
        for(Iterator iter=ts.iterator();iter.hasNext();){
            System.out.println(iter.next());
        }

    }

}
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return -1;
    }

    @Override
    public String toString() {
        return "name="+name+",age="+age;
    }
}
