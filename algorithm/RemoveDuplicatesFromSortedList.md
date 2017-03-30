# Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

    For example,

    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.

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
        ListNode node = head;

        while (node != null) {
            if (node.next == null) break;

            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}
```
