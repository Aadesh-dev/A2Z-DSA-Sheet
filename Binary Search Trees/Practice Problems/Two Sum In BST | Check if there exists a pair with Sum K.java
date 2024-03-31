class Solution {
    Stack<TreeNode> inorder = new Stack<>();
    Stack<TreeNode> revInorder = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {
        insertInorder(root);
        insertRevInorder(root);

        while(true) {
            TreeNode left = inorder.peek();
            TreeNode right = revInorder.peek();
            if(left == right) {
                break;
            } else {
                if(left.val + right.val == k) {
                    return true;
                } else if(left.val + right.val < k) {
                    inorder.pop();
                    insertInorder(left.right);
                } else {
                    revInorder.pop();
                    insertRevInorder(right.left);
                }
            }
        }
        return false;
    }

    public void insertInorder(TreeNode node) {
        while(node != null) {
            inorder.push(node);
            node = node.left;
        }
    }

    public void insertRevInorder(TreeNode node) {
        while(node != null) {
            revInorder.push(node);
            node = node.right;
        }
    }
}
//Time: O(n), Space: O(2 * h) => O(h)