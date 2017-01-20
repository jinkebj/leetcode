# Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

    Given linked list: 1->2->3->4->5, and n = 2.
    After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

    Given n will always be valid.
    Try to do this in one pass.

**Java:**
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;

        for (int i = 0; i < n; i++) q = q.next;

        if (q == null) return head.next;

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return head;
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
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        ListNode dummy(-1);
        dummy.next = head;

        ListNode* p = &dummy;
        ListNode* q = &dummy;

        for (int i = 0; i < n; i++)
            q = q->next;

        while (q->next) {
            p = p->next;
            q = q->next;
        }

        ListNode* tmp = p->next;
        p->next = p->next->next;
        delete tmp;

        return dummy.next;
    }
};
```
