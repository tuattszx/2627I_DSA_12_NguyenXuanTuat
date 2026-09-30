import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class problem4{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> lastop = new Stack<>();
        Stack<Integer> op1 = new Stack<>();
        Stack<String> op2  = new Stack<>();
        String line = br.readLine();
        if (line == null) return;
        int q = Integer.parseInt(line.trim());
        int len = 0;
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1){
                String x = st.nextToken();
                sb.append(x);
                op1.add(x.length());
                len += x.length();
                lastop.add(type);
            }
            else if (type == 2){
                int x = Integer.parseInt(st.nextToken());
                String sub = sb.substring(len - x, len);
                op2.add(sub);
                sb.delete(len - x, len);
                len -= x;
                lastop.add(type);
            }
            else if (type == 3){
                int idx = Integer.parseInt(st.nextToken());
                System.out.println(sb.charAt(idx - 1));
            }else{
                if (lastop.isEmpty()) continue;
                int op = lastop.peek(); lastop.pop();
                if (op == 1){
                    int x = op1.peek(); op1.pop();
                    sb.delete(len - x, len);
                    len -= x;
                }else{
                    String x = op2.peek(); op2.pop();
                    sb.append(x);
                    len += x.length();
                }
            }
        }
    }
}