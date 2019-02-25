import java.util.*;

public class SelectionSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 82, 30, 30, 77, 50 };
        SelectionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class SelectionSort {
    public static void sort(int a[]) {
        int n = a.length;
        int tmp;
        int i, j, k;

        for (i = 0; i < n; i++) {
            k = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[k]) k = j; // keep smallest elem in a[k]
            }
            if (k != i) {
                tmp = a[i];
                a[i] = a[k];
                a[k] = tmp;
            }
        }
    }
}
