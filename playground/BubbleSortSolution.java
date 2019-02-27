import java.util.*;

public class BubbleSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        BubbleSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class BubbleSort {
    public static void sort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            boolean exchange = false;
            // bubble up the minimal item
            for (int j = len - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                    exchange = true;
                }
            }
            if (!exchange) return;
        }
    }
}
