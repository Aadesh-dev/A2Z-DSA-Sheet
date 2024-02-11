class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) return p == q;
        if(p.val != q.val) return false;
        boolean isLeftChildSame = isSameTree(p.left, q.left);
        boolean isRightChildSame = isSameTree(p.right, q.right);
        return isLeftChildSame && isRightChildSame;
    }
}
//Time: O(n), Space: O(n)