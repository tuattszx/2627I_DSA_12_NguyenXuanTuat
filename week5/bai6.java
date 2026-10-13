import java.io.*;
import java.util.*;

public class bai6 {
    public static int quick(int[] arr, int lo, int hi){
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; ++j){
            if (arr[j] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                ++i;
            }
        }
        int temp = arr[i];
        arr[i] = arr[hi];
        arr[hi] = temp;
        for (int ii = 0; ii < arr.length; ++ii){
            System.out.print(arr[ii] + " ");
        }
        System.out.println();
        return i;
    }
    public static void Sort(int[] arr, int lo, int hi){
        if (lo >= hi) return;
        int mid = quick(arr, lo, hi);
        Sort(arr, lo, mid - 1);
        Sort(arr, mid + 1, hi);
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i){
            arr[i] = sc.nextInt();
        }
        Sort(arr, 0, n - 1);
    }
}