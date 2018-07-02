# Course Schedule

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

    Input: 2, [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take.
                 To take course 1 you should have finished course 0. So it is possible.

Example 2:

    Input: 2, [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take.
                 To take course 1 you should have finished course 0, and to take course 0 you should
                 also have finished course 1. So it is impossible.

Note:

- The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
- You may assume that there are no duplicate edges in the input prerequisites.

**Java: (BFS)**

- use Topological algorithm: put NODE with 0 indgree into the queue
- make indegree of NODE's successor dereasing 1
- keep the above steps with BFS
- if each node' indgree equals 0, then it is validated DAG (Directed Acyclic Graph), which means the course schedule can be finished

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites.length == 0) return true;

        // convert graph presentation from edges to indegree of adjacent list
        int indegree[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed
            indegree[prerequisites[i][0]]++;    

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) queue.add(i);

        // how many courses don't need prerequisites
        int canFinishCount = queue.size();  
        while (!queue.isEmpty()) {
            int prerequisite = queue.remove(); // already finished this prerequisite course
            for (int i = 0; i < prerequisites.length; i++)  {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        canFinishCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return (canFinishCount == numCourses);
    }
}
```

**Java: (DFS)**

- convert graph presentation from edge list to adjacency list first
- use DFS to check if there's cycle existing in any subset
- the graph is possibly not connected, so need to check every node
- The basic idea is using DFS to check if the current node was already included in the traveling path
- HashMap is used to save the previous results

```java
class Solution {
    public boolean canFinish(int n, int[][] edges) {
        if (n == 0 || edges.length == 0) return true;

        Map<Integer, HashSet<Integer>> neighbors = new HashMap<>(); // neighbors of each node
        Set<Integer>curPath = new HashSet<>(); // nodes on the current path
        for (int i = 0; i < edges.length; i++) { // convert graph presentation from edge list to adjacency list
            if (!neighbors.containsKey(edges[i][1])) neighbors.put(edges[i][1], new HashSet<Integer>());            
            neighbors.get(edges[i][1]).add(edges[i][0]);
        }

        for (int a[] : edges) // the graph is possibly not connected, need to check every node
            if (hasCycle(neighbors, a[0], -1, curPath)) return false; // DFS, check cycle
        return true;
    }     

    private boolean hasCycle(Map<Integer, HashSet<Integer>> neighbors, int kid, int parent, Set<Integer>curPath) {
        if (memo.containsKey(kid)) return memo.get(kid);
        if (curPath.contains(kid)) return true; // current node is already in the set of current path	    
        if (!neighbors.containsKey(kid)) return false;	   

        curPath.add(kid);
        for (Integer neighbor : neighbors.get(kid)) {
            boolean hasCycle = hasCycle(neighbors, neighbor, kid, curPath); // DFS, check cycle
            memo.put(kid, hasCycle);	        	
            if (hasCycle) return true;
        }
        curPath.remove(kid);	    
        return false;
    }

    private Map<Integer, Boolean>memo = new HashMap<>(); // save previous results for DFS
}
```
