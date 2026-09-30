import java.io.*;
import java.util.*;

public class problem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> Q = new ArrayDeque<>();
        int q = sc.nextInt();
        while (q-- > 0){
            int tp = sc.nextInt();
            if (tp == 1){
                int x = sc.nextInt();
                Q.add(x);
            }
            else if (tp == 2){
                if (!Q.isEmpty())
                    Q.poll();
            }else{
                System.out.println(Q.peek());
            }
        }
        sc.close();
    }
}
