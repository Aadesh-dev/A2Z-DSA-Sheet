class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights) {
            adj.get(flight[0]).add(Arrays.asList(flight[1], flight[2]));
        }
        int[] price = new int[n];
        for(int i = 0; i < n; i++) {
            price[i] = (int)1e9;
        }
        price[src] = 0;
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0, src, 0});
        while(!pq.isEmpty()) {
            int[] city = pq.poll();
            int stops = city[0], name = city[1], cost = city[2];
            if(stops > k) continue;
            for(List<Integer> neighbor : adj.get(name)) {
                if(price[neighbor.get(0)] > cost + neighbor.get(1)) {
                    price[neighbor.get(0)] = cost + neighbor.get(1);
                    pq.add(new int[]{stops + 1, neighbor.get(0), price[neighbor.get(0)]});
                }
            }
        }
        if(price[dst] == (int)1e9) return -1;
        return price[dst];
    }
}
//Time: O(V + E), Space: O(V)
//where V = n, E = flights.length