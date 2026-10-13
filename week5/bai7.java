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
     * Complete the 'findMedian' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int quick(List<Integer> arr, int lo, int hi){
        int pivot = arr.get(hi);
        int i = lo;
        for (int j = lo; j < hi; ++j){
            if (arr.get(j) <= pivot){
                int tmp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, tmp);
                ++i;
            }
        }
        int tmp = arr.get(i);
        arr.set(i, arr.get(hi));
        arr.set(hi, tmp);
        return i;
    }
    public static int dnc(List<Integer> arr, int lo, int hi, int k){
        if (lo == hi) return arr.get(lo);
        int pidx = quick(arr, lo, hi);
        if (pidx == k){
            return arr.get(pidx);
        }
        if (pidx > k)
            return dnc(arr, lo, pidx - 1, k);
        else
            return dnc(arr, pidx + 1, hi, k);
    }
    public static int findMedian(List<Integer> arr) {
    // Write your code here
        int k = arr.size() / 2;
        return dnc(arr, 0, arr.size() - 1, k);
    }

}

public class bai7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.findMedian(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}