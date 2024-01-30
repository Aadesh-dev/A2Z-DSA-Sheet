class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }
        return list;
    }
}
//Time: O(n), Space: O(n)