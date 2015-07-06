Thoughts:

1. Recursive is indeed easy and concise. However, in this question, it's hard to write in a tail-recursive way, and the linked list may be very long. Therefore, iteratively writing may be the best option...

2. Iterative: note the corner cases (when to stop, when to assign NULL to the last node).


====================================
Recursive Code:
------------------------------
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
    ListNode *swapPairs(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }
        ListNode *newHead = head->next;
        ListNode *headOfNextPair = newHead->next;
        newHead->next = head;
        head->next = swapPairs(headOfNextPair);
        return newHead;
    }
};

==========================================
Iterative Code:
------------------------------
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
    ListNode *swapPairs(ListNode *head) {
        if (head == NULL)
            return head;
        
        ListNode *prev = NULL, *first = head, *headOfNextPair, *second = head->next, *newHead = head;
        while (second != NULL) {
            if (prev != NULL) {
                prev->next = second;
            } else {
                newHead = second;
            }
            
            headOfNextPair = second->next;
            second->next = first;
            first->next = NULL;
            
            prev = first;
            first = headOfNextPair;
            if (first == NULL)
                second = NULL;
            else 
                second = first->next;
        }
        if (first != NULL && prev != NULL) {
            prev->next = first;
            first->next = NULL;
        }
        return newHead;
    }
};
