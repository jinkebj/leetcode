# Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
    return 1->2->2->4->3->5.

**Java:**
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLesser = new ListNode(-1);
        ListNode dummyGreater = new ListNode(-1);
        ListNode lesser = dummyLesser;
        ListNode greater = dummyGreater;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                lesser.next = cur;
                lesser = cur;
            } else {
                greater.next = cur;
                greater = cur;
            }
            cur = cur.next;
        }

        lesser.next = dummyGreater.next;
        greater.next = null;

        return dummyLesser.next;
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
    ListNode *partition(ListNode *head, int x) {
        ListNode left_dummy(-1);
        ListNode right_dummy(-1);

        auto left_cur = &left_dummy;
        auto right_cur = &right_dummy;

        for (ListNode *cur = head; cur; cur = cur->next) {
            if (cur->val < x) {
                left_cur->next = cur;
                left_cur = left_cur->next;
            } else {
                right_cur->next = cur;
                right_cur = right_cur->next;
            }
        }

        left_cur->next = right_dummy.next;
        right_cur->next = nullptr;

        return left_dummy.next;
    }
};
```
