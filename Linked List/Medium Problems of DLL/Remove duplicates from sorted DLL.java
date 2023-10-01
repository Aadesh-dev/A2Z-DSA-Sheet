class Solution{
    Node removeDuplicates(Node head){
       Node curr = head;
        while(curr.next != null) {
            if(curr.data == curr.next.data) {
                if(curr.prev != null) {
                    curr.prev.next = curr.next;
                } else {
                    head = head.next;
                }
                if(curr.next != null) {
                    curr.next.prev = curr.prev;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
//Time: O(n), Space: O(1)
//Similar to Delete all occurrences of a given key in a doubly linked list