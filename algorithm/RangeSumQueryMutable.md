# Range Sum Query - Mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

    Given nums = [1, 3, 5]

    sumRange(0, 2) -> 9
    update(1, 2)
    sumRange(0, 2) -> 8

Note:

- The array is only modifiable by the update function.
- You may assume the number of calls to update and sumRange function is distributed evenly.

**Java: (use Binary Indexed Tree)**
```java
class NumArray {

    public NumArray(int[] nums) {
        this.origNums = nums;
        this.bitArr = new int[origNums.length + 1];
        for (int i = 0; i < origNums.length; i++) {
            this.updateBIT(i, origNums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - origNums[i];
        origNums[i] = val;
		updateBIT(i, delta);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    private void updateBIT(int i, int delta) {
        i++;
        while (i < this.bitArr.length) {
            this.bitArr[i] += delta;
            i = i + (i & -i);
        }
    }

    private int getSum(int i) {
        i++;
        int result = 0;
        while (i > 0) {
            result += this.bitArr[i];
            i = i - (i & -i);
        }

        return result;
    }

    private int[] origNums;
    private int[] bitArr;
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
```
