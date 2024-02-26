class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        } 
        TreeNode node = buildTreeRec(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
        return node;
    }

    public TreeNode buildTreeRec(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2, Map<Integer, Integer> inorderMap) {
        if(p1 > p2 || i1 > i2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        TreeNode left = buildTreeRec(preorder, inorder, p1 + 1, p1 + (inorderMap.get(preorder[p1]) - i1), i1, inorderMap.get(preorder[p1]) - 1, inorderMap);
        TreeNode right = buildTreeRec(preorder, inorder, p1 + (inorderMap.get(preorder[p1]) - i1) + 1, p2, inorderMap.get(preorder[p1]) + 1, i2, inorderMap);
        root.left = left;
        root.right = right;
        return root;
    }
}
//Time: O(n), Space: O(n)

//Striver's code
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

        return root;
    }
}
//Time: O(n), Space: O(n)