# Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,

    Given 1->2->3->3->4->4->5, return 1->2->5.
    Given 1->1->1->2->3, return 2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node = head;

        while (node != null) {
            // find the last node of dups
            while (node.next != null && node.next.val == node.val) {
                node = node.next;
            }

            // duplicate detected
            if (pre.next == node) {
                pre = pre.next;
            } else {
                pre.next = node.next;
            }
            node = node.next;
        }

        return dummy.next;
    }
}
```

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // if current node is not unique, return deleteDuplicates with head.next
        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else { // If current node is unique, link it to the result of next list made by recursive call
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
```
