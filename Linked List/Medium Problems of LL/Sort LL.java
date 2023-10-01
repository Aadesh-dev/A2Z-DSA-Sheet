/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode i = head;
        while(i != null && i.next != null) {
            boolean swapped = false;
            ListNode j = head;
            while(j.next != null) {
                if(j.val > j.next.val) {
                    int temp = j.val;
                    j.val = j.next.val;
                    j.next.val = temp;
                    swapped = true;
                }
                j = j.next;
            }
            if(swapped == false) return head;
            i = i.next;
        }
        return head;
    }
}
//Time: O(n^2), Space: O(1) TLE

class Solution {
    public ListNode sortList(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while(curr != null && curr.next != null) {
            curr = curr.next.next;
            len += 2;
        }
        if(curr != null) {
            len++;
        }
        return mergeSort(head, 0, len - 1);
    }

    public static ListNode mergeSort(ListNode head, int low, int high) {
        if(low >= high) return head;
        int mid = (low + high) >> 1;
        mergeSort(head, low, mid);
        mergeSort(head, mid + 1, high);
        return sort(head, low, mid, high);
    }

    public static ListNode sort(ListNode head, int low, int mid, int high) {
        ListNode curr = head, left = new ListNode(), right = new ListNode();
        ListNode tempLeft = left, tempRight = right, main = left;
        int n1 = mid - low + 1;
        int n2 = high - mid;
        for(int i = 0; i <= high; i++) {
            if(i >= low && i <= mid) {
                if(i == low) {
                    tempLeft.val = curr.val;
                    main = curr;
                } else {
                    tempLeft.next = new ListNode(curr.val);
                    tempLeft = tempLeft.next;
                }
            } else if(i > mid && i <= high) {
                if(i == mid+1) {
                    tempRight.val = curr.val;
                } else {
                    tempRight.next = new ListNode(curr.val);
                    tempRight = tempRight.next;
                }
            }
            curr = curr.next;
        }
        int leftIndex = 0, rightIndex = 0;
        while(leftIndex < n1 && rightIndex < n2) {
            if(left.val < right.val) {
                main.val = left.val;
                left = left.next;
                leftIndex++;
            } else {
                main.val = right.val;
                right = right.next;
                rightIndex++;
            }
            main = main.next;
        }
        while(leftIndex < n1) {
            main.val = left.val;
            left = left.next;
            main = main.next;
            leftIndex++;
        }
        while(rightIndex < n2) {
            main.val = right.val;
            right = right.next;
            main = main.next;
            rightIndex++;
        }
        return head;
    }
}
//Time: O(n logn), Space: O(logn) TLE
//Here, values of the nodes are being sorted while the nodes' refrences remain in the same place.

public class Solution {
  
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
        
    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    prev.next = null;
    
    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(l1, l2);
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    
    if (l1 != null)
      p.next = l1;
    
    if (l2 != null)
      p.next = l2;
    
    return l.next;
  }

}
//Time: O(n logn), Space: O(logn)
//Here, the nodes themselves are being sorted along with the values and the nodes' refrences are changing.