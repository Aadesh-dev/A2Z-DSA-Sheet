class Solution
{
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> traversal = new ArrayList<>();
	    traversal.add(node.data);
        Node element = node.left;

        while(element != null && (element.left != null || element.right != null)) {
            traversal.add(element.data);
            if(element.left != null) {
                element = element.left;
            } else {
                element = element.right;
            }
        }

        preOrder(node, traversal, node);

        Stack<Integer> stack = new Stack<>();
        element = node.right;
        while(element != null && (element.left != null || element.right != null)) {
            stack.add(element.data);
            if(element.right != null) {
                element = element.right;
            } else {
                element = element.left;
            }
        }
        while(!stack.isEmpty()) {
            traversal.add(stack.pop());
        }

        return traversal;
	}
	
	public void preOrder(Node node, ArrayList<Integer> traversal, Node root) {
        if(node != null) {
            if(node.left == null && node.right == null && node != root) {
                traversal.add(node.data);
            }
            preOrder(node.left, traversal, root);
            preOrder(node.right, traversal, root);
        }
    }
}
//Time: O(n), Space: O(n)