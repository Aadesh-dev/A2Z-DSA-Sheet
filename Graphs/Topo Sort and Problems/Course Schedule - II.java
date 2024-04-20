class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            for(int node : adj.get(i)) {
                indegree[node]++;
            }
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        int i = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return order.size() == numCourses ? order.stream().mapToInt(x -> x).toArray() : new int[0];
    }
}
//Time: O(V + E), Space: O(V)