class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<List> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Node> verticals = new TreeMap<>();
        queue.add(new ArrayList<>(Arrays.asList(root, 0)));
        
        while(!queue.isEmpty()) {
            List curr = queue.poll();
            Node node = (Node) curr.get(0);
            int vertical = (int) curr.get(1);
            verticals.put(vertical, node);
            
            if(node.left != null) {
                List nodeList = new ArrayList<>(Arrays.asList(node.left, vertical - 1));
                queue.add(nodeList);
            }
            if(node.right != null) {
                List nodeList = new ArrayList<>(Arrays.asList(node.right, vertical + 1));
                queue.add(nodeList);
            }
        }
        
        for(Node node : verticals.values()) {
            res.add(node.data);
        }
        
        return res;
    }
}
//Time: O(n*log(n)), O(n)