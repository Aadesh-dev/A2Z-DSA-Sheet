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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderRecursive(root, list);
        return list;
    }

    public void postorderRecursive(TreeNode node, List<Integer> list) {
        if(node == null) return;
        postorderRecursive(node.left, list);
        postorderRecursive(node.right, list);
        list.add(node.val);
    }
}
//Time: O(n), Space: O(n)