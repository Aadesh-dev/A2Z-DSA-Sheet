class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int lh = 0, rh = 0;
        lh = getHeightOfBinaryTree(root.left);
        rh = getHeightOfBinaryTree(root.right);

        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);

        return Math.max((lh + rh), Math.max(ld, rd));
    }

    public int getHeightOfBinaryTree(TreeNode node) {
        if(node == null) return 0;
        int lh = 0, rh = 0;
        lh = getHeightOfBinaryTree(node.left);
        rh = getHeightOfBinaryTree(node.right);
        return 1 + Math.max(lh, rh);
    }
}
//Time: O(n ^ 2), Space: O(log2(n))

//Alternate brute:
class Solution {
    int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int lh = 0, rh = 0;
        lh = getHeightOfBinaryTree(root.left);
        rh = getHeightOfBinaryTree(root.right);

        maxd = Math.max(maxd, (lh + rh));

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return maxd;
    }

    public int getHeightOfBinaryTree(TreeNode node) {
        if(node == null) return 0;
        int lh = 0, rh = 0;
        lh = getHeightOfBinaryTree(node.left);
        rh = getHeightOfBinaryTree(node.right);
        return 1 + Math.max(lh, rh);
    }
}
//Time: O(n ^ 2), Space: O(log2(n))

class Solution {
    int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        recursiveDiameterOfBinaryTree(root);
        return maxd;
    }

    public int recursiveDiameterOfBinaryTree(TreeNode node) {
        if(node == null) return 0;
        int lh = 0, rh = 0;
        lh = recursiveDiameterOfBinaryTree(node.left);
        rh = recursiveDiameterOfBinaryTree(node.right);
        maxd = Math.max(maxd, (lh + rh));
        return 1 + Math.max(lh, rh);
    }
}
//Time: O(n), Space: O(log2(n))