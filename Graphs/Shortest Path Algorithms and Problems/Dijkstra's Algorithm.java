//PriorityQueue
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] dist = new int[V];
        for(int i = 0; i < V; i++) {
            if(i == S) {
                dist[i] = 0;
            } else {
                dist[i] = (int)1e9;
            }
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
        pq.add(new int[]{0, S});
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int weight = node[0], val = node[1];
            for(ArrayList<Integer> neighbor : adj.get(val)) {
                if(dist[neighbor.get(0)] > weight + neighbor.get(1)) {
                    dist[neighbor.get(0)] = weight + neighbor.get(1);
                    pq.add(new int[]{dist[neighbor.get(0)], neighbor.get(0)});
                }
            }
        }
        return dist;
    }
}
//Time: O(E log(V)), Space: O(V)
//PQ contains a pair - (n1,n2) for each node. n1 is the distance from source to the node and n2 is the value of the node.
//The smaller distance pairs have higher priority as they have a higher possibility of giving more shorter paths to their neighbors.
//If 2 distances are equal, then the node having smaller value is given higher priority. This doesn't have any significance on the logic
//because the nodes are arranged in a random manner in the graph and picking the smaller value node first won't make any differene. 
//It's just to have some logic to prioritize nodes having same distances.
//Explanation of TC: https://www.youtube.com/watch?v=3dINsjyfooY&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=34&ab_channel=takeUforward