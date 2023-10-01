public class Solution
{
    public static Node sortList(Node head) {
        Node node1 = head, node2;
        int temp;
        for(int i=0; i<3; i++) {
            while(node1.data == i) {
                node1 = node1.next;
                if(node1 == null) return head;
            }
            node2 = node1.next;
            while(node2 != null) {
                if(node2.data == i) {
                    temp = node1.data;
                    node1.data = node2.data;
                    node2.data = temp;
                    node1 = node1.next;
                }
                node2 = node2.next;
            }
        }
        return head;
    }
}
//Time: O(4n) => O(n), Space: O(1)

public class Solution
{
    public static Node sortList(Node head)
    {
        Node ptr = head;
        int[] cnt = new int[3];

        // Iterate while ptr is not empty
        while(ptr != null)
        {
            cnt[ptr.data]++;
            ptr = ptr.next;
        }

        ptr = head;
        int i = 0;

        // Updating data.
        while(ptr != null)
        {
            while(cnt[i] == 0)
            {
                i++;
            }

            ptr.data = i;
            cnt[i]--;
            ptr = ptr.next;
        }

        // Return head
        return head;
    }
}
//Time: O(2n) => O(n), Space: O(1)
//The problem boils down to how many occurrences of 0s, 1s and 2s are there. 
//We store the count in an array of size 3.
//Empty the array by taking one number from it, inserting in the LL and decrement that number's count.