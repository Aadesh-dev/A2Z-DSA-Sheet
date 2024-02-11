class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lh = 0, rh = 0;
        lh = getHeight(root.left);
        rh = getHeight(root.right);
        if(Math.abs(lh - rh) > 1) return false;

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);
        if(!leftBalanced || !rightBalanced) return false;
        return true;
    }

    public int getHeight(TreeNode node) {
        if(node == null) return 0;
        int lh = 0, rh = 0;
        lh = getHeight(node.left);
        rh = getHeight(node.right);
        return 1 + Math.max(lh, rh);
    }
}
//Time: O(n ^ 2), Space: O(log2(n))

class Solution {
    public boolean isBalanced(TreeNode root) {
        int result = isBalancedInteger(root);
        return result != -1;
    }

    public int isBalancedInteger(TreeNode node) {
        if(node == null) return 0;
        int lh = 0, rh = 0;
        lh = isBalancedInteger(node.left);
        if(lh == -1) return -1;
        rh = isBalancedInteger(node.right);
        if(rh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
}
//Time: O(n), Space: O(log2(n))