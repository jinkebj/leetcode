# Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        ListNode result;
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                fast = head;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next == null) return head;

        result = slow.next;
        fast.next = head;
        slow.next = null;

        return result;
    }
}
```

**C++:**
```c
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
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == NULL || k <= 0) return head;

        ListNode *result;
        ListNode *fast = head;
        ListNode *slow = head;

        for (int i = 0; i < k; i++) {
            if (fast->next) {
                fast = fast->next;
            } else {
                fast = head;
            }
        }

        while (fast->next) {
            fast = fast->next;
            slow = slow->next;
        }

        if (slow->next == NULL) return head;

        result = slow->next;
        slow->next = NULL;
        fast->next = head;

        return result;
    }
};
```
