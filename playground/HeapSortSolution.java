import java.util.*;

public class HeapSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 82, 30, 30, 77, 50 };
        HeapSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class HeapSort {
    public static void sort(int[] a) {
        // 构建一个大顶堆,因叶子节点已经满足大顶堆的定义,故只需从a[a.length/2-1]开始
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapify(a, i, a.length);
        }

        // 将堆顶记录和当前未经排序子序列的最后一个记录交换
        for (int i = a.length - 1; i > 0; i--) {
            int swap = a[0];
            a[0] = a[i];
            a[i] = swap;
            heapify(a, 0, i); // 将a中前i-1个记录重新调整为大顶堆
        }
    }

    // 已知a[]中的元素从a[i+1]开始均满足大顶堆的定义
    // 本函数进行调整，使加入a[i]后也满足大顶堆的定义
    // n为当前操作的大顶堆的大小
    private static void heapify(int a[], int i, int n) {
        int largest = i;
        int l = 2 * i + 1; // a[i]的左孩子
        int r = 2 * i + 2; // a[i]的右孩子

        // 找出a[i]和它的孩子节点中最大的元素
        if (l < n && a[l] > a[largest]) largest = l;
        if (r < n && a[r] > a[largest]) largest = r;

        // 判断是否需要调整当前树的根节点
        if (largest != i) {
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            // 调整受影响的子树
            heapify(a, largest, n);
        }
    }
}
