# Minimum Time Difference

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:

    Input: ["23:59","00:00"]
    Output: 1

Note:

    The number of time points in the given list is at least 2 and won't exceed 20000.
    The input time is legal and ranges from 00:00 to 23:59.

**Java:**
```java
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            time[i] = 60 * Integer.parseInt(timePoints.get(i).substring(0, 2)) + Integer.parseInt(timePoints.get(i).substring(3, 5));
        }

        Arrays.sort(time);

        int mm = Integer.MAX_VALUE;
        for (int i = 1; i < time.length; i++) mm = Math.min(mm, time[i] - time[i - 1]);

        return Math.min(mm, time[0] + (1440 - time[time.length - 1]));
    }
}
```
