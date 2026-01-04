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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        int carry = 0;
        while(l1 != null || l2 != null) {
            int n1 = (l1 != null) ? l1.val : 0;
            int n2 = (l2 != null) ? l2.val : 0;
            int sum = n1 + n2 + carry;
            int num = sum % 10;

            ListNode newNode = new ListNode(num);
            temp.next = newNode;
            temp = temp.next;
            carry = sum / 10;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        if(carry != 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }

        return ans.next;
    }
}