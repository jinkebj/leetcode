# Intersection of Two Arrays

Given two arrays, write a function to compute their intersection.

Example:

    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

  - Each element in the result must be unique.
  - The result can be in any order.

**Java:**
```java
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet = new HashSet<Integer>();
        Set<Integer> interset = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            numSet.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (numSet.contains(nums2[i])) interset.add(nums2[i]);
        }

        int[] ret = new int[interset.size()];
        int k = 0;
        for (Integer num : interset) {
            ret[k++] = num;
        }

        return ret;
    }
}
```
