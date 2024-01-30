import java.util.LinkedList;
import java.util.Queue;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static Node createTree(int []arr){
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(arr[0]);
        Node root = node;
        queue.add(node);

        for(int i = 1; i < arr.length; i+=2) {
            Node current = queue.poll();
            if((i) < arr.length) {
                Node left = new Node(arr[i]);
                current.left = left;
                queue.add(left);
            }
            if((i + 1) < arr.length) {
                Node right = new Node(arr[i + 1]);
                current.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
//Time: O(n), Space: O(n)