# Merge K Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

**Java: (use PriorityQueue)**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null  ||lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length,
            (o1, o2) -> {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        );

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) queue.add(tail.next);
        }

        return dummy.next;
    }
}
```

**Java: (recursive)**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int s, int e) {
        if (s == e)  return lists[s];
        if (s < e) {
            int q = (s + e) / 2;
            ListNode l1 = partion(lists, s, q);
            ListNode l2 = partion(lists, q + 1, e);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    // merge two sorted lists.
    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}
```

**C++:**
```c++
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.size() == 0) return nullptr;

        ListNode* p = lists[0];
        for (int i = 1; i < lists.size(); i++) {
            p = merge2Lists(p, lists[i]);
        }

        return p;
    }

    ListNode *merge2Lists(ListNode* l1, ListNode* l2) {
        if (l1 == nullptr) return l2;
        if (l2 == nullptr) return l1;

        ListNode dummy(-1);
        ListNode* p;

        for (p = &dummy; l1 != nullptr && l2 != nullptr; p = p->next) {
            if (l1-> val > l2->val) {
                p->next = l2;
                l2 = l2->next;
            } else {
                p->next = l1;
                l1 = l1->next;
            }
        }

        if (l1 == nullptr) p->next = l2;
        else p->next = l1;

        return dummy.next;
    }
};
```
