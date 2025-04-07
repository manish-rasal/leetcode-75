class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, end = head.next;
        while(end != null && end.next != null) {
            odd.next = end.next;
            odd = odd.next;
            end.next = odd.next;
            end = end.next;
            odd.next = even;
        }
        return head;
    }
}