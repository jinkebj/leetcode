# Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

**Analysis:**
- sort the people to make them stand from the highest to shortest
- for people with same height, sort them according to the count of people before them from small to big
- use the way similar to insert sorting to reorder the people

**Java:**
```java
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];

        Arrays.sort(people, (a, b) ->  a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ret = new ArrayList<>();
        for (int i = 0; i < people.length; i++) ret.add(people[i][1], new int[]{people[i][0], people[i][1]});

        return ret.toArray(new int[people.length][2]);
    }
}
```
