class Solution{
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        List<Integer> path = new ArrayList<>();
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(Arrays.asList(edge[1], edge[2]));
            adj.get(edge[1]).add(Arrays.asList(edge[0], edge[2]));
        }
        int[] parents = new int[n + 1];
        int[] dist = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            dist[i] = (int)1e9;
        }
        Queue<int[]> pq = new PriorityQueue<>((int[] p1, int[] p2) -> {
            if(p1[0] < p2[0]) {
                return -1;
            } else if(p1[0] > p2[0]) {
                return 1;
            } else {
                return p1[0] - p2[0];
            }
        });
        pq.add(new int[]{0, 1});
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int weight = node[0], val = node[1];
            for(List<Integer> neighbor : adj.get(val)) {
                if(dist[neighbor.get(0)] > weight + neighbor.get(1)) {
                    parents[neighbor.get(0)] = val;
                    dist[neighbor.get(0)] = weight + neighbor.get(1);
                    pq.add(new int[]{dist[neighbor.get(0)], neighbor.get(0)});
                }
            }
        }
        if(parents[n] != 0) {
            int curr = n;
            while(curr != 0) {
                path.add(curr);
                curr = parents[curr];
            }
            path.add(dist[n]);
            Collections.reverse(path);
        } else {
            path.add(-1);
        }
        return path;
    }
}
//Time: O(m log(n)), Space: O(n)
//Djikstra's algo only gives us the weight of the shortest path and not the path itself.
//Hence, we use memoization to remember the previous node of every node along the shortest path from 1 to n.

//Problem is not present in the A2Z sheet but is included in Striver's Graph series.
//Problem link: https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1