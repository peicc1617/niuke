import java.util.ArrayList;
import java.util.List;

public class First {
    public List funciton1(List a){
        return a;
    }
    class Second extends First{
        public ArrayList function1(List a){
            ArrayList b=(ArrayList) a;
            return b;

        }
    }
}
