class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;

        ListNode slow = new ListNode(-1, head);
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = temp.next;
        temp.next = null;
        return head;
    }
}