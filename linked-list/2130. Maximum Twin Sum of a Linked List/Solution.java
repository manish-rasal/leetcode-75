class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            st.add(slow.val);
            slow = slow.next;
        }

        int result = 0;
        while(slow != null) {
            result = Math.max(result, slow.val + st.pop());
            slow = slow.next;
        }
        return result;
    }
}