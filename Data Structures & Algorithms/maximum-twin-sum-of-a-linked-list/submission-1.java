class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode previous = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode savedNext = slow.next;
            slow.next = previous;

            previous = slow;
            slow = savedNext;
        }

        int maxSum = Integer.MIN_VALUE;

        while (slow != null) {
            int sum = previous.val + slow.val;
            maxSum = Math.max(maxSum, sum);

            previous = previous.next;
            slow = slow.next;
        }
        return maxSum;
    }
}