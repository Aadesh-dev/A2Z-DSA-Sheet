//kth smallest (Left-Root-Right):
class Solution {
    int count;

    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        int kthSmallestLeft = kthSmallest(root.left, k);
        if(kthSmallestLeft != -1) return kthSmallestLeft;
        count++;
        if(count == k) return root.val;
        int kthSmallestRight = kthSmallest(root.right, k);
        if(kthSmallestRight != -1) return kthSmallestRight;
        return -1;
    }
}
//Time: O(n), Space: O(h)

//kth largest (Right-Root-Left):
class Solution
{
    int count;
    
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        if(root == null) return -1;
        int kthLargestRight = kthLargest(root.right, K);
        if(kthLargestRight != -1) return kthLargestRight;
        count++;
        if(count == K) return root.data;
        int kthLargestLeft = kthLargest(root.left, K);
        if(kthLargestLeft != -1) return kthLargestLeft;
        return -1;
    }
}
//Time: O(n), Space: O(h)