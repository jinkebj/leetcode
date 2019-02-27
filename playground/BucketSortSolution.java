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
        int[][] buckets = new int[a.length][10];

        // 需要遍历的次数由数组最大值的位数来决定
        for (int i = 1; max / i > 0; i = i * 10) {

            // 获取每一位数字(个、十、百、千位...分配到桶子里)
            for (int j = 0; j < a.length; j++) {
                int num = (a[j] / i) % 10;
                buckets[j][num] = a[j];
            }

            // 回收10个桶子里的元素
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < a.length ; l++) {
                    // 如果桶子里面有元素就回收
                    if (buckets[l][j] != 0) {
                        a[k++] = buckets[l][j];
                        buckets[l][j] = 0;
                    }
                }
            }
        }
    }

    private static int findMax(int[] a, int L, int R) {
        if (L == R) return a[L]; // 判断数组是否只有一个数

        int i = a[L];
        int j = findMax(a, L + 1, R); // 递归找出整体的最大值

        return (i > j) ? i : j;
    }
}
