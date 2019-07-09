import java.lang.reflect.Array;
import java.util.*;
public class Main4{
    public static void main(String args[]) {
        Arrays.asList();
        int array[] = new int[1001];
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            for (int i = 0; i < 1001; i++) {
                array[i] = 0;
            }
            int count = sc.nextInt();

            while (count > 0 ) {
                array[sc.nextInt()] = 1;
                count--;
            }
            for (int i = 1; i < 1001; i++) {
                if (array[i] != 0) System.out.println(i);

            }
        }
    }
}
