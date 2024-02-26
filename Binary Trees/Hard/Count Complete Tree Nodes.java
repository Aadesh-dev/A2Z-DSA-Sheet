class Solution {
    int count;
    public int countNodes(TreeNode root) {
        count = 0;
        preorderRecursive(root);
        return count;
    }

    public void preorderRecursive(TreeNode node) {
        if(node == null) return;
        count++;
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }
}
//Time: O(n), Space: O(h)

//Striver's code
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int left = getHeightLeft(root);
        int right = getHeightRight(root);
        
        //If left and right are equal it means that the tree is complete and hence go for 2^h -1.
        if(left == right) return (int)Math.pow(2, left + 1) - 1;
            
        //else recursively calculate the number of nodes in left and right and add 1 for root.
        else return countNodes(root.left)+ countNodes(root.right)+1;
    }
    
    
    public int getHeightLeft(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }
    
    
    public int getHeightRight(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }
}
//Time: O(log(n)^2), Space: O(log(n)) => O(h)
