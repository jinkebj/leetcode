import java.util.*;

public class MergeSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 82, 30, 30, 77, 50 };
        MergeSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}

class MergeSort {
    // 对数组a中[left, right]部分排序
    public static void sort(int[] a, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;

        // 二路归并排序里面有两个sort，多路归并排序里面写多个sort就可以了
        sort(a, left, mid);
        sort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    // 合并数组a中的有序区间[left, mid]和[mid + 1, right]
    private static void merge(int[] a, int left, int mid, int right) {
        int[] tmp = new int[a.length];
        int lPointer = left;
        int rPointer = mid + 1;
        int tIndex = left;

        while (lPointer <= mid && rPointer <= right) {
            if (a[lPointer] <= a[rPointer])
                tmp[tIndex++] = a[lPointer++];
            else
                tmp[tIndex++] = a[rPointer++];
        }

        while (lPointer <= mid) tmp[tIndex++] = a[lPointer++]; // 如果左边有剩余则归并
        while (rPointer <= right) tmp[tIndex++] = a[rPointer++]; // 如果右边有剩余则归并

        // 从临时数组拷贝到原数组
        for (int i = left; i <= right; i++) a[i] = tmp[i];
    }
}
