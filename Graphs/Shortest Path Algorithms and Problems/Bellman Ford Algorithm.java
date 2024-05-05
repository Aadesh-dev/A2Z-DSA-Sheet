class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            dist[i] = (int) 1e8;
        }
        dist[S] = 0;
        for(int i = 1; i < V; i++) {
            int count = 0;
            for(ArrayList<Integer> edge : edges) {
                int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
                if(dist[u] < (int) 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    count++;
                }
            }
            if(count == 0) break;
        }
        for(ArrayList<Integer> edge : edges) {
            int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
            if(dist[u] < (int) 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
//Time: O(V * E), Space: O(V)