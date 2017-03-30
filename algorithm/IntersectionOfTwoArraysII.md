# Intersection of Two Arrays II

Given two arrays, write a function to compute their intersection.

Example:

    Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

  - Each element in the result should appear as many times as it shows in both arrays.
  - The result can be in any order.

Follow up:

  - What if the given array is already sorted? How would you optimize your algorithm?
  - What if nums1's size is small compared to nums2's size? Which algorithm is better?
  - What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

**Java:**
```java
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> interset = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (numMap.containsKey(nums1[i])) numMap.put(nums1[i], numMap.get(nums1[i]) + 1);
            else numMap.put(nums1[i], 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (numMap.containsKey(nums2[i]) && numMap.get(nums2[i]) > 0) {
                interset.add(nums2[i]);
                numMap.put(nums2[i], numMap.get(nums2[i]) - 1);
            }
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
