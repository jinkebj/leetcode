import java.util.*;

public class QuickSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        QuickSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}

class QuickSort {
    // 对数组a中[start, end]部分排序
    public static void sort(int[] a, int start, int end) {
        if (start >= end) return;
        int i = start;
        int j = end;
        int pivot = a[i];

        while (i < j) {
            // 下面两个循环的位置不能颠倒，因为第一次坑的位置在最左边
            while (i < j && a[j] >= pivot) j--;
            a[i] = a[j];
            while (i < j && a[i] <= pivot) i++;
            a[j] = a[i];
        }
        a[i] = pivot;

        sort(a, start, i - 1); // 递归左边的数组
        sort(a, i + 1, end); // 递归右边的数组
    }
}
