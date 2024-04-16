class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            
            adjacencyList.get(first).add(second);
            adjacencyList.get(second).add(first);
        }
        
        return adjacencyList;
    }
}
//Time: O(V + m), Space: O(2 * m), where m = edges.length