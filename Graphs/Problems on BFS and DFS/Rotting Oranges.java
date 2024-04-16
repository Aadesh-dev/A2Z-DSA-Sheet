class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0, m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    int[] rotten = new int[3];
                    rotten[0] = i;
                    rotten[1] = j;
                    rotten[2] = 0;
                    q.add(rotten);
                    visited[i][j] = 2;
                }
            }
        }
        while(!q.isEmpty()) {
            int[] rotten = q.poll();
            int i = rotten[0], j = rotten[1];
            if(isValid(grid, visited, i + 1, j)){
                int[] neighbor = new int[3];
                neighbor[0] = i + 1;
                neighbor[1] = j;
                neighbor[2] = rotten[2] + 1;
                time = Math.max(time, neighbor[2]);
                q.add(neighbor);
                visited[i + 1][j] = 2;
            }
            if(isValid(grid, visited, i - 1, j)){
                int[] neighbor = new int[3];
                neighbor[0] = i - 1;
                neighbor[1] = j;
                neighbor[2] = rotten[2] + 1;
                time = Math.max(time, neighbor[2]);
                q.add(neighbor);
                visited[i - 1][j] = 2;
            }
            if(isValid(grid, visited, i, j + 1)){
                int[] neighbor = new int[3];
                neighbor[0] = i;
                neighbor[1] = j + 1;
                neighbor[2] = rotten[2] + 1;
                time = Math.max(time, neighbor[2]);
                q.add(neighbor);
                visited[i][j + 1] = 2;
            }
            if(isValid(grid, visited, i, j - 1)){
                int[] neighbor = new int[3];
                neighbor[0] = i;
                neighbor[1] = j - 1;
                neighbor[2] = rotten[2] + 1;
                time = Math.max(time, neighbor[2]);
                q.add(neighbor);
                visited[i][j - 1] = 2;
            }
        }
        boolean allRotten = true;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1 && visited[i][j] != 2) {
                    allRotten = false;
                    break;
                }
            }
        }
        return allRotten ? time : -1;
    }

    public boolean isValid(int[][] grid, int[][] visited, int i, int j) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 && visited[i][j] != 2) return true;
        return false;
    }
}
//Time :O(m * n), Space: O(m * n)


//Smarter:
//Striver's solution: https://www.youtube.com/watch?v=yf3oUhkvqA0&ab_channel=takeUforward (check code)