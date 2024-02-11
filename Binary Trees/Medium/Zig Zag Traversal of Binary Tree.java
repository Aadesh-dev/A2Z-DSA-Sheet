class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            while(levelSize > 0) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                levelSize--;
            }
            if(reverse) Collections.reverse(level);
            traversal.add(level);
            reverse = !reverse;
        }
        return traversal;
    }
}


//Faster
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int levelSize = queue.size();
            while(levelSize > 0) {
                TreeNode node = queue.poll();
                if(reverse) {
                    level.addFirst(node.val);
                } else {
                    level.add(node.val);
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                levelSize--;
            }
            traversal.add(level);
            reverse = !reverse;
        }
        return traversal;
    }
}
//Time: O(n), Space: O(n)