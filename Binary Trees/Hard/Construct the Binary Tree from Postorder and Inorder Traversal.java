class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeRec(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildTreeRec(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        root.left = buildTreeRec(inorder, inStart, inRoot - 1, postorder, postStart, postStart + inRoot - inStart - 1, map);
        root.right = buildTreeRec(inorder, inRoot + 1, inEnd, postorder, postStart + inRoot - inStart, postEnd - 1, map);
        return root;
    }
}
//Time: O(n), Space: O(n)