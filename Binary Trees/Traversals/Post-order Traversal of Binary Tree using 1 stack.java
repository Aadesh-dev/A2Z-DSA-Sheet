class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
        }
        Collections.reverse(list);

        return list;
    }
}
//Time: O(n), Space: O(n)