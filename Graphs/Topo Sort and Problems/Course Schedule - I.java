class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
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
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            for(int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0) q.add(neighbor);
            }
        }
        return count == numCourses;
    }
}
//Time: O(V + E), Space: O(V)