class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<List> queue = new LinkedList<>();
        Map<Integer, Map<Integer, Queue<Integer>>> verticals = new TreeMap<>();
        queue.add(new ArrayList<>(Arrays.asList(root, 0, 0)));

        while(!queue.isEmpty()) {
            List curr = queue.poll();
            TreeNode node = (TreeNode) curr.get(0);
            int vertical = (int) curr.get(1);
            int level = (int) curr.get(2);
            if(!verticals.containsKey(vertical)) {
                Map<Integer, Queue<Integer>> levels = new TreeMap<>();
                verticals.put(vertical, levels);
            }
            if(!verticals.get(vertical).containsKey(level)) {
                Queue<Integer> nodes = new PriorityQueue<>();
                verticals.get(vertical).put(level, nodes);
            }
            verticals.get(vertical).get(level).add(node.val);
            if(node.left != null) {
                List nodeList = new ArrayList<>(Arrays.asList(node.left, vertical - 1, level + 1));
                queue.add(nodeList);
            }
            if(node.right != null) {
                List nodeList = new ArrayList<>(Arrays.asList(node.right, vertical + 1, level + 1));
                queue.add(nodeList);
            }
        }

        for(Map.Entry<Integer, Map<Integer, Queue<Integer>>> verticalSet : verticals.entrySet()) {
            List<Integer> verticalTraversal = new ArrayList<>();
            for(Map.Entry<Integer, Queue<Integer>> levelSet : verticalSet.getValue().entrySet()) {
                Queue<Integer> nodes = levelSet.getValue();
                while(!nodes.isEmpty()) {
                    verticalTraversal.add(nodes.poll());
                }
            }
            res.add(verticalTraversal);
        }

        return res;
    }
}
//Time: O(n * log(n)), Space: O(n)
//Another way to store the nodes in the queue would be to create a helper class having 3 variables instead of a list.