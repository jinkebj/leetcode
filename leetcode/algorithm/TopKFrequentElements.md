# Top K Frequent Elements

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

- You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
- Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

**Java: (use priority queue)**
```java
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) res.add(0, pq.poll().getKey());

        return res;
    }
}
```

**Java: (bucket sort)**
```java
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) res.addAll(bucket[pos]);
        }

        return res;
    }
}
```
