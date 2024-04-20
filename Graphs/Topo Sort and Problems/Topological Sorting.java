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
        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < v; i++) {
            if(visited[i] == 0) {
                dfs(adj, stack, visited, i);
            }
        }
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public static void dfs(List<List<Integer>> adj, Stack<Integer> stack, int[] visited, int i) {
        visited[i] = 1;
        for(int node : adj.get(i)) {
            if(visited[node] == 0) {
                dfs(adj, stack, visited, node);
            }
        }
        stack.add(i);
    }

}
//Time: O(V + E + V) => O(V + E), Space: O(V)