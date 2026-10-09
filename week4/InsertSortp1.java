import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    public static void printList(List<Integer> arr){
        for (int i = 0; i < arr.size(); ++i){
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
    public static void insertionSort1(int n, List<Integer> arr) {
        for (int i = 0; i < n; ++i){
            int j = i - 1, tmp = arr.get(i);
            boolean ok = false, sw = false;
            while (!ok && j >= 0){
                if (arr.get(j) > tmp){
                    arr.set(j + 1, arr.get(j));
                    --j;
                    printList(arr);
                    sw = true;
                }else{
                    ok = true;
                }
            }
            arr.set(j + 1, tmp);
            if (sw)
                printList(arr);
        }
    }

}

public class InsertSortp1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
