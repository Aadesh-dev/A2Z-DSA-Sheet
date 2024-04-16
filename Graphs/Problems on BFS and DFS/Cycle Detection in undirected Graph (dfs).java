class Solution {
    public boolean detectCycle(int[] src, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src[0]] = 1;
        for(int neighbor : adj.get(src[0])) {
            if(visited[neighbor] == 0) {
                if(detectCycle(new int[]{neighbor, src[0]}, adj, visited)) return true;
            } else if(neighbor != src[1]) {
                return true;
            }
        }
        return false;
    }
    
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0)
                if(detectCycle(new int[]{i, -1}, adj, visited)) return true;
        }
        return false;
    }
}
//Time: O(V + 2E) + O(V), Space: O(V)