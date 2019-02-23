import java.util.*;

public class InsertionSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class InsertionSort {
    public static void sort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int tmp = a[i];
            int j;
            for (j = i - 1; j >= 0 && tmp < a[j]; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }
}
