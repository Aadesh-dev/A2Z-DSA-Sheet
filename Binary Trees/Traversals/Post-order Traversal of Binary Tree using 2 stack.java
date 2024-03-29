class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        while(!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.add(node);
            if(node.left != null) stack1.add(node.left);
            if(node.right != null) stack1.add(node.right);
        }

        while(!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }

        return list;
    }
}
//Time: O(n), Space: O(n)