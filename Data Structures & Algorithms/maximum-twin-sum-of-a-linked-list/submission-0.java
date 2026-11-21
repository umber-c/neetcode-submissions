class Solution {
    public int pairSum(ListNode head) {
        // Find the last node of the first half.
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half.
        ListNode previous = null;
        ListNode current = slow.next;

        while (current != null) {
            ListNode savedNext = current.next;
            current.next = previous;

            previous = current;
            current = savedNext;
        }

        // Reconnect the first half to the reversed second half.
        slow.next = previous;

        // Compare twin pairs.
        ListNode first = head;
        ListNode second = previous;
        int maxSum = Integer.MIN_VALUE;

        while (second != null) {
            int sum = first.val + second.val;
            maxSum = Math.max(maxSum, sum);

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}