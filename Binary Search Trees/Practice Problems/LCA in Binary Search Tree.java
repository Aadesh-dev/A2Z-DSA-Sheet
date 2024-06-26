class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            if(curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            } else if(curr.val < p.val && curr.val < q.val) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return curr;
    }
}
//Time: O(h), Space: O(1)