import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambda {
    public static void checkAndExcuter(List<Person> personList,NameChecker nameChecker,Excutor excutor){
        for (Person p:personList) {
            if(nameChecker.check(p)){
                excutor.excute(p);
            }
        }
    }
    public static void checkAndExcuter1(List<Person> personList, Predicate<Person> predicate, Consumer<Person> consumer){
        for (Person p:personList) {
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }

    public static void main(String[] args) {
       List<Person> guiltyPersons= Arrays.asList(new Person("Yixing","Zhao",25),
       new Person("Yanggui","Li",30));
       checkAndExcuter1(guiltyPersons,p -> p.getLastName().startsWith("Z"),p -> System.out.println(p.getFirstName()));
    };
}
