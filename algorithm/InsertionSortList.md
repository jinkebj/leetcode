# Insertion Sort List

Sort a linked list using insertion sort.

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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val < cur.val) {
                cur.next = next.next;
                insertNodeToSortedList(dummy, next);
            } else {
                cur = next;
                next = next.next;
            }
        }

        return dummy.next;
    }

    private void insertNodeToSortedList(ListNode start, ListNode node) {
        ListNode pre = start;
        ListNode cur = start.next;
        while (cur != null && cur.val <= node.val) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = node;
        node.next = cur;
    }
}
```

**C++:**

![](InsertionSortList-P1.jpg)

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
    ListNode *insertionSortList(ListNode *head) {
        if (!head) return NULL;

        ListNode dummy(INT_MIN);
        dummy.next = head;

        ListNode* p;
        ListNode* pre; // previous node of p

        for (p = head->next, pre = head; p; pre = p, p = p->next) {
            for (ListNode * cur = &dummy; cur->next != p; cur = cur->next) {
                if (cur->next->val > p->val) {
                    // insert between cur and cur->next
                    pre->next = p->next;
                    p->next = cur->next;
                    cur->next = p;
                    p = pre;
                    break;
                }
            }
        }

        return dummy.next;
    }
};
```
