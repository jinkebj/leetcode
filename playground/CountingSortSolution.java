import java.util.*;

public class CountingSortSolution {
    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 82, 30, 30, 77, 50 };
        int ret[] = CountingSort.sort(a);
        System.out.println(Arrays.toString(ret));
    }
}

class CountingSort {
    public static int[] sort(int[] a) {
        // 存放临时数据的数组tmp, 初始元素都是0, k为数组中最大元素
        int k = findMax(a, 0, a.length - 1);
        int[] tmp = new int[k + 1];

        // 计算数组中每个元素i出现的次数, 存入数组tmp中的第i项, 即原数组中的元素值为tmp数组中的下标
        for (int i = 0; i < a.length; i++) tmp[a[i]]++;

        // 计算数组中小于等于每个元素的个数, 即从tmp中的第一个元素开始, 每一项和前一项相加
        for (int j = 1; j <= k; j++) tmp[j] = tmp[j] + tmp[j - 1];

        // 用ret数组存放排序结果
        int[] ret = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            ret[tmp[a[i]] - 1] = a[i]; // 小于等于a[i]的元素(包括a[i]本身)有tmp[a[i]]个
            tmp[a[i]]--; // 下次再放同样大小的元素，就要往前挤一个位置
        }

        return ret;
    }

    private static int findMax(int[] a, int L, int R) {
        if (L == R) return a[L]; // 判断数组是否只有一个数

        int i = a[L];
        int j = findMax(a, L + 1, R); // 递归找出整体的最大值

        return (i > j) ? i : j;
    }
}
