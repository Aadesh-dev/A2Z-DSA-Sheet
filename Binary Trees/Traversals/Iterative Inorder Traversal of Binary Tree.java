class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(true) {
            if(node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if(!stack.isEmpty()) {
                    TreeNode parent = stack.pop();
                    list.add(parent.val);
                    node = parent.right;
                } else break;
            }
        }
        return list;
    }
}
//Time: O(n), Space: O(n)