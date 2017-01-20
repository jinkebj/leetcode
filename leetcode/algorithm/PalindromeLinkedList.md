# Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

**Analysis:**
```
This can be solved by reversing the 2nd half and compare the two halves. Let's start with an example [1, 1, 2, 1].

In the beginning, set two pointers fast and slow starting at the head.

    1 -> 1 -> 2 -> 1 -> null
    sf

(1) Move: fast pointer goes to the end, and slow goes to the middle.

    1 -> 1 -> 2 -> 1 -> null
              s          f

(2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.

    1 -> 1    null <- 2 <- 1           
    h                      s

(3) Compare: run the two pointers head and slow together and compare.

    1 -> 1    null <- 2 <- 1             
         h            s
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // for odd nodes, make right half smaller
        if (fast != null) slow = slow.next;

        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
```
