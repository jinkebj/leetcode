# Binary Search

## 关于二分查找法

二分查找法主要是解决在“一堆数中找出指定的数”这类问题。

想要应用二分查找法，这“一堆数”必须有以下特征：

- 存储在数组中
- 有序排列

所以如果是用链表存储的，就无法在其上应用二分查找法了。

至于是顺序递增排列还是递减排列，数组中是否存在相同的元素都不要紧。

## 二分查找法的基本实现

二分查找法在算法家族大类中属于“分治法”，分治法基本都可以用递归来实现的.
二分查找法的递归实现如下：

**Java: (use recursive)**
```java
public static int bSearch(int[] a, int key) {
    return doBSearch(a, key, 0, a.length - 1);
}

private static int doBSearch(int[] a, int key, int lo, int hi) {
    if (lo > hi) return -1;

    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) return doBSearch(a, key, lo, mid - 1);
    else if (key > a[mid]) return doBSearch(a, key, mid + 1, hi);
    else return mid;
}
```

不过所有的递归都可以自行定义stack来解递归，所以二分查找法也可以不用递归实现，而且它的非递归实现甚至可以不用栈，因为二分的递归其实是尾递归，它不关心递归前的所有信息。

**Java: (don't use recursive)**
```java
public static int bSearch(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }

    return -1;
}
```

## 用二分查找法找寻边界值

之前的应用都是在数组中找到一个数要与目标相等，如果不存在则返回-1。我们也可以用二分查找法找寻边界值，也就是说在有序数组中找到“正好大于（小于）目标数”的那个数。

用数学的表述方式就是：
- 在集合中找到一个大于（小于）目标数t的数x，使得集合中的任意数要么大于（小于）等于x，要么小于（大于）等于t。

举例来说：

    int array = {2, 3, 5, 7, 11, 13, 17};
    int target = 7;

    那么上界值应该是11，因为它“刚刚好”大于7；下届值则是5，因为它“刚刚好”小于7。

**Java: (用二分查找法找寻上届)**
```java
// find the first element which is larger than target in sorted array
public static int getBSearchUpperBound(int[] array, int target) {
    int low = 0;
    int high = array.length - 1;
    if (low > high || target >= array[high]) return -1;


    while (high > low) {
        int mid = low + (high - low) / 2;
        if (array[mid] > target) high = mid;
        else low = mid + 1;
    }

    return mid;
}
```

与精确查找不同之处在于，精确查找分成三类：大于，小于，等于（目标数）。而界限查找则分成了两类：大于和不大于。

如果当前找到的数大于目标数时，它可能就是我们要找的数，所以需要保留这个索引，也因此if (array[mid] > target)时 high=mid; 而没有减1。

**Java: (用二分查找法找寻下届)**
```java
// find the last element which is less than target in sorted array
public static int getBSearchLowerBound(int[] array, int target) {
    int low = 0;
    int high = array.length - 1;
    if (high < low  || target <= array[low]) return -1;

    while (low < high) {
        int mid = low + (high - low + 1) / 2; // make mid lean to large side
        if (array[mid] < target) low = mid;
        else high = mid - 1;
    }

    return mid;
}
```

下届寻找基本与上届相同，需要注意的是在取中间索引时，使用了向上取整。若同之前一样使用向下取整，那么当low == high-1，而array[low] 又小于 target时就会形成死循环。因为low无法往上爬超过high。

这两个实现都是找严格界限，也就是要大于或者小于。如果要找松散界限，也就是找到大于等于或者小于等于的值（即包含自身），只要对代码稍作修改就好了：

    去掉判断数组边界的等号：

    target >= array[high]改为 target > array[high]

    在与中间值的比较中加上等号：

    array[mid] > target改为array[mid] >= target

## 二分查找法的缺陷

二分查找法的O(log n)让它成为十分高效的算法。不过它的缺陷却也是那么明显的。就在它的限定之上：

必须有序，我们很难保证我们的数组都是有序的。当然可以在构建数组的时候进行排序，可是又落到了第二个瓶颈上：它必须是数组。

数组读取效率是O(1)，可是它的插入和删除某个元素的效率却是O(n)。因而导致构建有序数组变成低效的事情。

解决这些缺陷问题更好的方法应该是使用二叉查找树了，最好自然是自平衡二叉查找树了，自能高效的（O(n log n)）构建有序元素集合，又能如同二分查找法一样快速（O(log n)）的搜寻目标数。
