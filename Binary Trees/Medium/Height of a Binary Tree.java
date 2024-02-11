class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            depth++;
            int levelSize = treeQueue.size();
                
            while(levelSize != 0) {
                TreeNode node = treeQueue.poll();
                if(node.left != null) treeQueue.add(node.left);
                if(node.right != null) treeQueue.add(node.right);
                levelSize--;
            }
        }
        return depth;
    }
}
//Time: O(n), Space: O(n)

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = 0, rh = 0;
        lh = maxDepth(root.left);
        rh = maxDepth(root.right);
        return 1 + Math.max(lh, rh);
    }
}
//Time: O(n), Space: O(log2(n)) - Height of the tree
//Space can be O(n) in case of a degenerate tree.