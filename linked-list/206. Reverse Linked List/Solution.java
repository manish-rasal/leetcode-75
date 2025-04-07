class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode temp = head.next;
        ListNode prev = null;
        while(temp != null) {
            head.next = prev;
            prev = head;
            head = temp;
            temp = temp.next;
        }
        head.next = prev;
        return head;
    }
}