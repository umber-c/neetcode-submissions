class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }

            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int total = v1 + v2 + carry;
            int digit = total % 10;
            carry = total / 10;

            curr.next = new ListNode(digit);
            curr = curr.next;
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}