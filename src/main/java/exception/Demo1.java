package exception;

import java.util.*;
public class Demo1 {
    private static final int N_MAX = 55;
    private static final int INT_MAX= 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] in = sc.next().toCharArray();
        int[] counts = new int[N_MAX];
        for (int i=1; i<=in.length; i++) {
            if (in[i-1] == 'R') {
                counts[i] = counts[i-1] + 1;
            }
            else {
                counts[i] = counts[i-1];
            }
        }
        int ans = INT_MAX;
        for (int i=0; i<=in.length; i++) {
            int left  = i - counts[i];
            int right = counts[in.length] - counts[i];
            ans = Math.min(left+right, ans);
        }
        System.out.println(ans);
    }
}