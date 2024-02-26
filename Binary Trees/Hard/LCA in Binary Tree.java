class Solution {
    List<TreeNode> pPath, qPath;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path = new ArrayList<>();
        pPath = qPath = new ArrayList<>();
        generatePaths(root, path, p, q);
        TreeNode lca = new TreeNode(0);

        int i = 0;
        while(i < pPath.size() && i < qPath.size()) {
            if(pPath.get(i) == qPath.get(i)) {
                lca = pPath.get(i);
            }
            i++;
        }
        return lca;
    }

    public void generatePaths(TreeNode node, List<TreeNode> path, TreeNode p, TreeNode q) {
        if(node == null || (!pPath.isEmpty() && !qPath.isEmpty())) return;
        path.add(node);
        if(node.left != null) generatePaths(node.left, path, p, q);
        if(node.right != null) generatePaths(node.right, path, p, q);
        if(node == p) {
            pPath = new ArrayList<>(path);
        } else if(node == q) {
            qPath = new ArrayList<>(path);
        }
        path.remove(path.size() - 1);
    }
}
//Time: O(2n) => O(n), Space: O(3h) => O(h)

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            return left;
        } else {
            return right;
        }
    }
}
//Time: O(n), Space: O(n)