class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode top = stack.pop();
        pushAll(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode node) {
        while(node != null) {
            stack.add(node);
            node = node.left;
        }
    }
}
//Time: O(1) Average, Space: O(h)
//We are inserting n elements in the stack and there will be n next() calls. So not all next() calls
//will result in n insertions in the stack as most of the elements will be inserted in a single call
//and most of the calls will be in O(1). Hence, on average TC will be O(1). 