import java.util.*;

public class HeapSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class HeapSort {
    public static void sort(int[] a) {
        // 构建一个大顶堆
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            HeapSort.adjustHeap(a, i, a.length - 1);
        }

        // 将堆顶记录和当前未经排序子序列的最后一个记录交换
        for (int i = a.length - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            HeapSort.adjustHeap(a, 0, i - 1); // 将a中前i-1个记录重新调整为大顶堆
        }
    }

    // 已知a[start~end]中除了start之外均满足堆的定义
    // 本函数进行调整，使a[start~end]成为一个大顶堆
    private static void adjustHeap(int[] a, int i, int len) {
        int temp, j;
        temp = a[i];
        for (j = 2 * i; j < len; j *= 2) { // 沿关键字较大的孩子结点向下筛选
            if (j < len && a[j] < a[j + 1]) ++j; // j为关键字中较大记录的下标
            if (temp >= a[j]) break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }
}
