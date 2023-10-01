class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, res = new ListNode(), p3 = res;
        int carry = 0;
        while(p1 != null || p2 != null) {
            int sum = 0;
            if(p1 == null) {
                sum = p2.val + carry;
                p2 = p2.next;
            } else if(p2 == null) {
                sum = p1.val + carry;
                p1 = p1.next;
            } else {
                sum = p1.val + p2.val + carry;
                p1 = p1.next;
                p2 = p2.next;
            }
            carry = sum / 10;
            p3.next = new ListNode(sum % 10);
            p3 = p3.next;
        }
        if(carry > 0) {
            p3.next = new ListNode(carry);
        }
        return res.next;
    }
}
//Time: O(max(l1,l2)), Space: O(max(l1,l2) + 1) => O(1) as we don't include answer in space complexity.