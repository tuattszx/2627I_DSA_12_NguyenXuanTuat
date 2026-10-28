import java.io.*;
import java.util.*;

public class bai2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j){
            if (s.charAt(i) != s.charAt(j)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
