class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        if(root == null) return new ArrayList<>();
        Queue<Node> treeQueue = new LinkedList<>();
        ArrayList<Integer> traversal = new ArrayList<>();
        treeQueue.add(root);
        int levelNum = 0;
        while(!treeQueue.isEmpty()) {
            int levelSize = treeQueue.size();
            Stack<Node> stack = new Stack<>();
                
            while(levelSize != 0) {
                Node currNode = treeQueue.poll();
                if(currNode.left != null) treeQueue.add(currNode.left);
                if(currNode.right != null) treeQueue.add(currNode.right);
                if(levelNum % 2 == 0) {
                    stack.add(currNode);
                } else {
                   traversal.add(currNode.data); 
                }
                levelSize--;
            }
            while(!stack.isEmpty()) {
                traversal.add(stack.pop().data);
            }
            levelNum++;
        }
        return traversal;
    }
}
//Time: O(n), Space: O(n)