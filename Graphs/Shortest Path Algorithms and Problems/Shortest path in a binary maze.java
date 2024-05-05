//Source and destination are always (0,0) and (n-1,n-1) respectively. 8-directional movement.
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = (int) 1e9;
            }
        }
        dist[0][0] = 1;
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{1, 0, 0});
        while(!pq.isEmpty()) {
            int[] cell = pq.poll();
            int d = cell[0], row = cell[1], col = cell[2];
            int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
            int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
            for(int i = 0; i < 8; i++) {
                int newRow = row + dy[i], newCol = col + dx[i];
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 && dist[newRow][newCol] > d + 1) {
                    dist[newRow][newCol] = d + 1;
                    pq.add(new int[]{d + 1, newRow, newCol});
                }
            }
        }
        if(dist[n - 1][n - 1] == (int) 1e9) {
            return -1;
        }
        return dist[n - 1][n - 1];
    }
}
//Time: O(4*N*M), Space: O(N*M)
//PriorityQueue is not used here as all distances will always be 1 more than the previous one.
//Hence, there is no need of getting the minimum distance node from the queue.

//Source and destination are given. 4-directional movement.
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1;
		if(source[0] == destination[0] && source[1] == destination[1]) return 0;
		int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dist[i][j] = (int) 1e9;
            }
        }
        dist[source[0]][source[1]] = 0;
        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0, source[0], source[1]});
        while(!pq.isEmpty()) {
            int[] cell = pq.poll();
            int d = cell[0], row = cell[1], col = cell[2];
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            for(int i = 0; i < 4; i++) {
                int newRow = row + dy[i], newCol = col + dx[i];
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && dist[newRow][newCol] > d + 1) {
                    dist[newRow][newCol] = d + 1;
					if(newRow == destination[0] && newCol == destination[1]) return dist[newRow][newCol];
                    pq.add(new int[]{d + 1, newRow, newCol});
                }
            }
        }
        return -1;
    }
}
//O(4*N*M), Space: O(N*M)