# Network Delay Time

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:

    N will be in the range [1, 100].
    K will be in the range [1, N].
    The length of times will be in the range [1, 6000].
    All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.

**Analysis:**
```
use Dijkstra's algorithm Heap Implementation
```

**Java:**
```java
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Integer> dist = new HashMap<>();

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] info : times) {
            graph.computeIfAbsent(info[0], k -> new ArrayList<int[]>()).add(new int[]{info[1], info[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (info1, info2) -> info1[1] - info2[1]
        );
        minHeap.offer(new int[]{K, 0});

        while (!minHeap.isEmpty()) {
            int[] info = minHeap.poll();
            if (dist.containsKey(info[0])) continue;

            dist.put(info[0], info[1]);
            if (graph.containsKey(info[0])) {
                for (int[] edgeInfo : graph.get(info[0])) {
                    if (!dist.containsKey(edgeInfo[0])) {
                        minHeap.offer(new int[]{edgeInfo[0], info[1] + edgeInfo[1]});
                    }
                }
            }
        }

        if (dist.size() != N) return -1;
        int ret = 0;
        for (int val: dist.values())
            ret = Math.max(ret, val);
        return ret;
    }
}
```