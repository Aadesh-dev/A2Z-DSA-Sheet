import java.util.*;

/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

import java.util.List;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        inorderRecursive(root, inorder);
        preorderRecursive(root, preorder);
        postorderRecursive(root, postorder);
        traversals.add(inorder);
        traversals.add(preorder);
        traversals.add(postorder);
        return traversals;
    }

    public static void inorderRecursive(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inorderRecursive(node.left, list);
        list.add(node.data);
        inorderRecursive(node.right, list);
    }

    public static void preorderRecursive(TreeNode node, List<Integer> list) {
        if(node == null) return;
        list.add(node.data);
        preorderRecursive(node.left, list);
        preorderRecursive(node.right, list);
    }

    public static void postorderRecursive(TreeNode node, List<Integer> list) {
        if(node == null) return;
        postorderRecursive(node.left, list);
        postorderRecursive(node.right, list);
        list.add(node.data);
    }
}
//Time: O(n), Space: O(n)