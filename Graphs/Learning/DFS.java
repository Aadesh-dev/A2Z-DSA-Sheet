class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        int visited[] = new int[V];
        dfsRecursive(0, visited, dfs, adj);
        return dfs;
        
    }
    
    public void dfsRecursive(int node, int[] visited, ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj) {
        dfs.add(node);
        visited[node] = 1;
        for(int neighbor : adj.get(node)) {
            if(visited[neighbor] == 0) {
                dfsRecursive(neighbor, visited, dfs, adj);
            }
        }
    }
}
//Time: O(n + 2E) for bi-directional graphs and O(n + E) for uni-directional graphs.
//Space: O(3n) => O(n)