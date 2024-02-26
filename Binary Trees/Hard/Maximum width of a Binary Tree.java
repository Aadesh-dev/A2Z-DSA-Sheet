//Null nodes are included
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> treeQueue = new LinkedList<>();
        int maxWidth = 1;
        treeQueue.add(new Pair(root, 0));
        while(!treeQueue.isEmpty()) {
            List<Pair<TreeNode, Integer>> level = new ArrayList<>();
            int levelSize = treeQueue.size();
                
            while(levelSize != 0) {
                Pair<TreeNode, Integer> pair = treeQueue.poll();
                level.add(pair);
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                int finalIndex = 0;
                if(index != 0) {
                    finalIndex = index - 1;
                }
                if(node.left != null) {
                    Pair<TreeNode, Integer> leftPair = new Pair(node.left, 2 * finalIndex + 1);
                    treeQueue.add(leftPair);
                }
                if(node.right != null) {
                    Pair<TreeNode, Integer> rightPair = new Pair(node.right, 2 * finalIndex + 2);
                    treeQueue.add(rightPair);
                }
                levelSize--;
            }
            maxWidth = Math.max(maxWidth, level.get(level.size() - 1).getValue() - level.get(0).getValue() + 1);
        }
        return maxWidth;
    }
}
//Time: O(n), Space: O(n)

//Null nodes are excluded
public class Solution {
    public static int getMaxWidth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        int maxWidth = 1;
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
            maxWidth = Math.max(maxWidth, level.size());
        }
        return maxWidth;
    }
}
//Time: O(n), Space: O(n)