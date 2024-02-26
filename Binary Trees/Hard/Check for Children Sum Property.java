public class Solution {
    public static boolean isParentSum(Node root) {
        int childSum = getChildSum(root);
        return childSum == -1 ? false : true;
    }

    public static int getChildSum(Node node) {
        if(node == null) return 0;
        int left = getChildSum(node.left);
        int right = getChildSum(node.right);
        if(left == -1 || right == -1 || (!isLeafNode(node) && node.data != left + right)) {
            return -1;
        }
        return node.data;
    }

    public static boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }
}
//Time: O(n), Space: O(n)