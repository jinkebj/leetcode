# Merge K Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

**Java:**
```java

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
