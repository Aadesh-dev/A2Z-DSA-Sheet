public class Solution
{
    public static int minValue(Node root) {
        if(root == null) return -1;
        while(root.left != null) root = root.left;
        return root.data;
    }
}
//Time: O(h), Space: O(1)