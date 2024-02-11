class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> reversePostOrder = new ArrayList<>();
        preorderRecursive(root, preOrder);
        postOrderRecursive(root, reversePostOrder);
        if(preOrder.size() != reversePostOrder.size()) {
            return false;
        }
        for(int i = 0; i < preOrder.size(); i++) {
            if(preOrder.get(i) != reversePostOrder.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void preorderRecursive(TreeNode node, List<Integer> preOrder) {
        if(node == null) {
            preOrder.add(-1);
            return;
        }
        preOrder.add(node.val);
        preorderRecursive(node.left, preOrder);
        preorderRecursive(node.right, preOrder);
    }

    public void postOrderRecursive(TreeNode node, List<Integer> reversePostOrder) {
        if(node == null) {
            reversePostOrder.add(-1);
            return;
        }
        reversePostOrder.add(node.val);
        postOrderRecursive(node.right, reversePostOrder);
        postOrderRecursive(node.left, reversePostOrder);
    }
}
//Time: O(2n) => O(n), Space: O(2n) => O(n)

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetricUtil(root.left, root.right);
    }

    static boolean isSymmetricUtil(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;

        return (root1.val==root2.val) && 
        isSymmetricUtil(root1.left, root2.right) && 
        isSymmetricUtil(root1.right, root2.left);
    }
}
//Time: O(n), Space: O(n)