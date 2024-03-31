class Solution {
    int curr = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] preorder, int ub) {
        if(curr >= preorder.length || preorder[curr] > ub) return null;
        TreeNode node = new TreeNode(preorder[curr]);
        curr++;
        node.left = helper(preorder, node.val);
        node.right = helper(preorder, ub);
        return node;
    }
}
//Time: O(n), Space: O(1)

//Alternate - Not using a global variable.
class Solution {
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode helper(int[] preorder, int ub, int[] curr) {
        if(curr[0] >= preorder.length || preorder[curr[0]] > ub) return null;
        TreeNode node = new TreeNode(preorder[curr[0]]);
        curr[0]++;
        node.left = helper(preorder, node.val, curr);
        node.right = helper(preorder, ub, curr);
        return node;
    }
}
//Time: O(n), Space: O(1)