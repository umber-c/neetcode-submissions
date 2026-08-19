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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      int lengthOfList = getLength(head);
        int del = lengthOfList - n;
        if (del == 0) {
            return head.next;
        }
        ListNode temp = head;
        while (del > 1) {
            temp = temp.next;
            del--;
        }
        temp.next = temp.next.next;

        return head;
    }
    private int getLength(ListNode head){
        int length = 0;
        ListNode temp = head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }
}
