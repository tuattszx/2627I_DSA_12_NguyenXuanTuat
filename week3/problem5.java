import java.util.Scanner;
import java.util.Stack;

public class problem5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int result = 0;
        Stack<Integer> st1 = new Stack<>(), st2 = new Stack<>(), st3 = new Stack<>();
        for (int i = 0, x; i < n; ++i){
            x = sc.nextInt();
            sum1 += x;
            st1.add(x);
        }
        result = sum1;
        for (int i = 0, x; i < m; ++i){
            x = sc.nextInt();
            sum2 += x;
            st2.add(x);
        }
        result = Math.min(sum2, result);
        for (int i = 0, x; i < k; ++i){
            x = sc.nextInt();
            sum3 += x;
            st3.add(x);
        }
        result = Math.min(sum3, result);
        while (sum1 != sum2 || sum2 != sum3){
            while (sum1 > result && !st1.isEmpty()){
                sum1 -= st1.peek();
                st1.pop();
            }
            while (sum2 > result && !st2.isEmpty()){
                sum2 -= st2.peek();
                st2.pop();
            }
            while (sum3 > result && !st3.isEmpty()){
                sum3 -= st3.peek();
                st3.pop();
            }
            result = Math.min(Math.min(sum1, sum2), sum3);
        }
        System.out.println(result);
    }
}