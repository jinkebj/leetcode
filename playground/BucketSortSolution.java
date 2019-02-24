import java.util.*;

public class BucketSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 82, 30, 30, 77, 50 };
        BucketSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

class BucketSort {
    public static void sort(int[] a) {
        int max = findMax(a, 0, a.length - 1);

        // 需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {
            int[][] buckets = new int[a.length][10];

            // 获取每一位数字(个、十、百、千位...分配到桶子里)
            for (int j = 0; j < a.length; j++) {
                int num = (a[j] / i) % 10;
                // 将其放入桶子里
                buckets[j][num] = a[j];
            }

            // 回收桶子里的元素
            int k = 0;

            // 有10个桶子
            for (int j = 0; j < 10; j++) {
                // 对每个桶子里的元素进行回收
                for (int l = 0; l < a.length ; l++) {
                    // 如果桶子里面有元素就回收(数据初始化会为0)
                    if (buckets[l][j] != 0) {
                        a[k++] = buckets[l][j];
                    }
                }
            }
        }
    }

    private static int findMax(int[] a, int L, int R) {
        // 如果该数组只有一个数，那么最大的就是该数组第一个值了
        if (L == R) return a[L];

        int i = a[L];
        int j = findMax(a, L + 1, R); // 找出整体的最大值

        return (i > j) ? i : j;
    }
}
