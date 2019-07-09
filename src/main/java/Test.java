package cn.quantgroup.pinjamancepat.controller.ka;


import java.util.List;
import java.util.Vector;

class Test {

    public static void main(String[] args) {
        (new Test()).act();
    }

    public void act() {
        Vector<First> vs = new Vector<First>();
//      vs.add(new Base());//错误，First容器只能装First及其子类，不能装First的超类，
        vs.add(new Second());

        List<? super Second> vSuper = new Vector<First>();//可以容纳本类及子类，但无法容纳超类
//      vSuper.add(new Base());错误vSuper只是Vector<First>的引用，First的容器只能装First及其子类，不能装它的超类
//      vSuper.add(new First()); 错误
        vSuper.add(new Second()); //正确
        vSuper.add(new Third()); //正确

        checkSuper(new Vector<First>());//可以传递超类、本类参数，但无法传递子类参数
        checkSuper(new Vector<Second>());
//      checkSuper(new Vector<Third>());//错误

        List<? extends Second> vExtends = new Vector<Second>();//不能容纳任何子类、本类、超类
//      vExtends.add(new First());错误
//      vExtends.add(new Second());//错误
//      vExtends.add(new Third());//错误
        vExtends.add(null);//正确，但是没用

//      checkExtends(new Vector<First>());//错误，无法传递超类参数
        checkExtends(new Vector<Second>());//能够传递本类及子类参数
        checkExtends(new Vector<Third>());

        //List<? super T> 当容器用时，能容纳T本身及T的子类，但无法容纳T的超类。用来向函数传递参数时，只能传递T及T的超类
        //List<? extends T> 当容器用时，只能容纳null，没什么用处。用来向函数传递参数时，只能传递T及T的子类，不能传递T的超类
    }


    public void checkSuper(List<? super Second> a) {

    }

    public void checkExtends(List<? extends Second> a) {

    }

    public class Base{

    }

    public class First extends Base{

    }

    public class Second extends First {
        public Second() {

        }
    }

    public class Third extends Second {
        public Third() {

        }
    }
}


