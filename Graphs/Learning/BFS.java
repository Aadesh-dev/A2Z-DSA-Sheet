class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        int visited[] = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            bfs.add(curr);
            for(int neighbor : adj.get(curr)) {
                if(visited[neighbor] == 0) {
                    queue.add(neighbor);
                    visited[neighbor] = 1;
                }
            }
        }
        return bfs;
    }
}
//Time: O(n + 2E) for bi-directional graphs and O(n + E) for uni-directional graphs.
//Space: O(3n) => O(n)
//The inner for loop runs for every neighbor of every node, which means for the degree of every node.
//The total degree of a bi-directional graph is 2*E and E of a uni-directional graph.