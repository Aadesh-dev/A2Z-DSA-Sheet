public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = headA;
        while(node != null) {
            set.add(node);
            node = node.next;
        }
        node = headB;
        while(node != null) {
            if(set.contains(node)) return node;
            node = node.next;
        }
        return null;
    }
}
//Time: O(m+n), Space: O(max(m,n))

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        int sizeA = 0, sizeB = 0;
        while((nodeA != null && nodeA.next != null) || (nodeB != null && nodeB.next != null)) {
            if(nodeA != null && nodeA.next != null) {
                sizeA += 2;
                nodeA = nodeA.next.next;
            }
            if(nodeB != null && nodeB.next != null) {
                sizeB += 2;
                nodeB = nodeB.next.next;
            }
        }
        if(nodeA != null) sizeA++;
        if(nodeB != null) sizeB++;
        nodeA = headA;
        nodeB = headB;
        while(sizeA > sizeB) {
            nodeA = nodeA.next;
            sizeA--;
        }
        while(sizeB > sizeA) {
            nodeB = nodeB.next;
            sizeB--;
        }
        while(nodeA != null & nodeB != null) {
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return null;
    }
}

//Time: O(m + (m - n) + n) => O(2m), Space: O(1), where m > n

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        
        while(d1 != d2) {
            d1 = d1 == null? headB:d1.next;
            d2 = d2 == null? headA:d2.next;
        }
        
        return d1;
    }
}
//Time: O(2*max(length of list1,length of list2)), Space: O(1)
////Time: O(m + (m - n) + n) => O(2m), Space: O(1), where m > n

//For final solution:
//https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/