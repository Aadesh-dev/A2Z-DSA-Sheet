import java.util.List;
public class Solution {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> traversals = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        Pair<TreeNode, Integer> pair = new Pair(root, 1);
        stack.add(pair);

        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> currPair = stack.pop();
            TreeNode node = currPair.getKey();
            int value = currPair.getValue();
            if(value == 1) {
                preorder.add(node.data);
                Pair<TreeNode, Integer> newPair = new Pair(node, 2);
                stack.add(newPair);
                if(node.left != null) {
                    Pair<TreeNode, Integer> leftPair = new Pair(node.left, 1);
                    stack.add(leftPair);
                }
            }
            else if(value == 2) {
                inorder.add(node.data);
                Pair<TreeNode, Integer> newPair = new Pair(node, 3);
                stack.add(newPair);
                if(node.right != null) {
                    Pair<TreeNode, Integer> rightPair = new Pair(node.right, 1);
                    stack.add(rightPair);
                }
            } else {
                postorder.add(node.data);
            }
        }

        traversals.add(inorder);
        traversals.add(preorder);
        traversals.add(postorder);
        return traversals;
    }
}
//Time: O(3n) => O(n), Space: O(4n) => O(n)