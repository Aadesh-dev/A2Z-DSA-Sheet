public class Solution {

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int[] indegree = new int[v];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < v; i++) {
            for(int node : adj.get(i)) {
                indegree[node]++;
            }
        }
        for(int i = 0; i < v; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return res;
    }

}
//Time: O(V + E), Space: O(V)