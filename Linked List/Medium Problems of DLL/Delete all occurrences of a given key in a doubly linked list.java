class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node node = head;
        while(node != null) {
            if(node.data == x) {
                if(node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    head = node.next;
                }
                if(node.next != null) {
                    node.next.prev = node.prev;
                }
            }
            node = node.next;
        }
        return head;
    }
}
//Time: O(n), Space: O(1)
//Similar to Remove duplicates from sorted DLL
//Edge cases missed:
//1) Back to back deletions. Eg. 1 2 3 4 5 5 and x = 5
//2) All same numbers and all to be deleted. Eg. 5 5 5 5 5 and x = 5