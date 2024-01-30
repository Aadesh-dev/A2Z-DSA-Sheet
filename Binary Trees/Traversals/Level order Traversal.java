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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> levelQueue = new LinkedList<>();
            while(!treeQueue.isEmpty()) {
                levelQueue.add(treeQueue.poll());
            }
                
            while(!levelQueue.isEmpty()) {
                TreeNode node = levelQueue.poll();
                level.add(node.val);
                if(node.left != null) treeQueue.add(node.left);
                if(node.right != null) treeQueue.add(node.right);
            }
            traversal.add(level);
        }
        return traversal;
    }
}
//Time: O(n), Space: O(n)


//Smarter
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = treeQueue.size();
                
            while(levelSize != 0) {
                TreeNode node = treeQueue.poll();
                level.add(node.val);
                if(node.left != null) treeQueue.add(node.left);
                if(node.right != null) treeQueue.add(node.right);
                levelSize--;
            }
            traversal.add(level);
        }
        return traversal;
    }
}
//Time: O(n), Space: O(n)