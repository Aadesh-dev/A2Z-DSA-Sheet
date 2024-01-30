/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderRecursive(root, list);
        return list;
    }

    public void inorderRecursive(TreeNode node, List<Integer> list) {
        if(node == null) return;
        inorderRecursive(node.left, list);
        list.add(node.val);
        inorderRecursive(node.right, list);
    }
}
//Time: O(n), Space: O(n)