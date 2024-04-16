class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces =  0, n = isConnected.length;
        int visited[] = new int[n];
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                provinces++;
                bfs(isConnected, n, i, visited);
            }
        }
        return provinces;
    }

    public void bfs(int[][] isConnected, int n, int curr, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i = 0; i < n; i++) {
                if(isConnected[node][i] == 1 && visited[i] == 0 && node != i) {
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
//Time: O(n + (n + 2E)), O(n)

//DFS solution:
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int provinces =  0;
        int visited[] = new int[V];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(adj.get(i).get(j) == 1) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        for(int i = 0; i < V; i++) {
            if(visited[i] == 0) {
                provinces++;
                dfs(adjList, i, visited);
            }
        }
        return provinces;
    }
    
    static void dfs(List<List<Integer>> adjList, int node, int[] visited) {
        visited[node] = 1;
        for(int neighbor : adjList.get(node)) {
            if(visited[neighbor] == 0) {
                dfs(adjList, neighbor, visited);
            }
        }
    }
};
//Time: O(n + (n + 2E)), O(n)