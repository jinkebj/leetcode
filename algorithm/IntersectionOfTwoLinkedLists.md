# Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗            
    B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

  - If the two linked lists have no intersection at all, return null.
  - The linked lists must retain their original structure after the function returns.
  - You may assume there are no cycles anywhere in the entire linked structure.
  - Your code should preferably run in O(n) time and use only O(1) memory.

**Analysis:**
```
Route1: a1 -> a2 -> c1 -> c2 -> c3 -> (connect to)b1 -> b2 -> b3 -> c1
Route2: b1 -> b2 -> b3 -> c1 -> c2 -> c3 -> (connect to)a1 -> a2 -> c1
Route1 & Route2 will meet after second iteration
```

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // if a & b have different length, then we will stop the loop after second iteration
        while (a != b) {
            a = (a == null ? headB : a.next);
            b = (b == null? headA : b.next);
        }

        return a;
    }
}
```
