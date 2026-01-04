/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeSort(ListNode l1, ListNode l2) {
        ListNode merged = null;
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }
        if(l1.val <= l2.val) {
            merged = l1;
            merged.next = mergeSort(l1.next, l2);
        } else {
            merged = l2;
            merged.next = mergeSort(l1, l2.next);
        }
        return merged;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        int last = lists.length -1;
        while(last != 0) {
            int i = 0;
            int j = last;
            while(i < j) {
                lists[i] = mergeSort(lists[i], lists[j]);
                i++;
                j--;
                if(i>=j) {
                    last = j;
                }
            }
        }
        return lists[0];
    }
}