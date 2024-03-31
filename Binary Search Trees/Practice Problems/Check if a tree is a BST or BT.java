class Solution {

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(j) >= list.get(i)) return false;
            }
            for(int j = i + 1; j < list.size(); j++) {
                if(list.get(j) <= list.get(i)) return false;
            }
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
//Time: O(n^2), Space: O(n)

class Solution {

    public boolean isValidBST(TreeNode root) {
        return inorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean inorder(TreeNode root, long min, long max) {
        if(root == null) return true;
        boolean isLeftValid = inorder(root.left, min, Math.min(max, root.val));
        boolean isCurrentValid = min < root.val && root.val < max;
        boolean isRightValid = inorder(root.right, Math.max(min, root.val), max);
        return isLeftValid && isCurrentValid && isRightValid;
    }
}
//Time: O(n), Space: O(h)