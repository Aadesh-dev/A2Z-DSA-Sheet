class Solution {
    public boolean detectCycle(int V, int src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, -1});
        visited[src] = 1;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int neighbor : adj.get(node[0])) {
                if(neighbor != node[1]) {
                    if(visited[neighbor] == 1) return true;
                    q.add(new int[]{neighbor, node[0]});
                    visited[neighbor] = 1;
                }
            }
        }
        return false;
    }
    
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0)
                if(detectCycle(V, i, adj, visited)) return true;
        }
        return false;
    }
}
//Time: O(V + 2E) + O(V), Space: O(V)