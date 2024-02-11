//Iterative right view
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if(root == null) return traversal;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize > 0) {
                TreeNode node = queue.poll();
                if(levelSize == 1) traversal.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                levelSize--;
            }
        }
        return traversal;
    }
}
//Time: O(n), Space: O(n)

//Iterative left view
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        if(root == null) return;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            int originalLevelSize = queue.size();
            while(levelSize > 0) {
                TreeNode<Integer> node = queue.poll();
                if(levelSize == originalLevelSize) System.out.print(node.data + " ");
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                levelSize--;
            }
        }
    }
}
//Time: O(n), Space: O(n)

//Recursive right view
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        rightView(root, 0, view);
        return view;
    }

    public void rightView(TreeNode node, int currLevel, List<Integer> view) {
        if(node == null) return;
        if(currLevel == view.size()) {
            view.add(node.val);
        }
        rightView(node.right, currLevel + 1, view);
        rightView(node.left, currLevel + 1, view);
    }
}
//Time: O(n), Space: O(h)

//Recursive left view
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        leftView(root, 0, view);
        return view;
    }

    public void leftView(TreeNode node, int currLevel, List<Integer> view) {
        if(node == null) return;
        if(currLevel == view.size()) {
            view.add(node.val);
        }
        leftView(node.left, currLevel + 1, view);
        leftView(node.right, currLevel + 1, view);
    }
}
//Time: O(n), Space: O(h)