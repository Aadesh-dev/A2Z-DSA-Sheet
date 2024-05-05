public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        int[] dist = new int[n];
        for(int i = 0; i < n; i++) {
            if(i == src) {
                dist[i] = 0;
            } else {
                dist[i] = (int) 1e9;
            }
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int neighbor : adj.get(node)) {
                if(dist[neighbor] == 1e9) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
//Time: O(V + 2E), Space: O(V)