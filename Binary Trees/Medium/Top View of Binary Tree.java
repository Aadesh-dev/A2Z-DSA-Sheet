class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Queue<List> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Node> verticals = new TreeMap<>();
        queue.add(new ArrayList<>(Arrays.asList(root, 0)));
        
        while(!queue.isEmpty()) {
            List curr = queue.poll();
            Node node = (Node) curr.get(0);
            int vertical = (int) curr.get(1);
            if(!verticals.containsKey(vertical)) {
                verticals.put(vertical, node);
            }
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
//Time: O(n + v*log(v)), Space: O(n)
//where v = number of verticals