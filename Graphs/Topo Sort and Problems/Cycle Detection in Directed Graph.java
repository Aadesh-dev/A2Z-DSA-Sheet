public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    int count = 0;
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0; i <= n; i++) {
        adj.add(new ArrayList<>());
    }
    for(ArrayList <Integer> edge : edges) {
        adj.get(edge.get(0)).add(edge.get(1));
    }
    int[] indegree = new int[n + 1];
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i <= n; i++) {
        for(int node : adj.get(i)) {
            indegree[node]++;
        }
    }
    for(int i = 0; i <= n; i++) {
        if(indegree[i] == 0) q.add(i);
    }
    while(!q.isEmpty()) {
        int node = q.poll();
        count++;
        for(int neighbor : adj.get(node)) {
            indegree[neighbor]--;
            if(indegree[neighbor] == 0) q.add(neighbor);
        }
    }
    return count < n;
  }
}
//Time: O(V + E), Space: O(V)