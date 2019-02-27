import java.util.*;

public class ShellSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 82, 30, 30, 77, 50 };
        ShellSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class ShellSort {
    public static void sort(int a[]) {
        int n = a.length;
        int tmp;
        int i, j;
        int gap = n;
        while (gap > 1) { // gap缩小至1时排序结束
            gap = gap / 3 + 1;
            // 将全部元素分为 gap 个子序列, 所有距离为gap的元素放在同一个子序列中排序
            for (i = gap; i < n; i++) {
                tmp = a[i];
                for (j = i - gap; j >= 0 && tmp < a[j]; j -= gap)
                    a[j + gap] = a[j];
                a[j + gap] = tmp;
            }
        }
    }
}
