//DFS
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length, lands = 0;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1 && visited[i][j] == 0) {
                    dfs(grid, visited, i, j, n, m);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) 
                    lands++;
            }
        }
        return lands;
    }

    public void dfs(int[][] grid, int[][] visited, int r, int c, int n, int m) {
        visited[r][c] = 1;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++) {
            int nr = r + dy[i], nc = c + dx[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                dfs(grid, visited, nr, nc, n, m);
            }
        }
    }
}
//Time: O(n * m * 4) => O(n * m), Space: O(n * m)

//BFS
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length, lands = 0;
        int[][] visited = new int[n][m];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1 && visited[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }
        while(!q.isEmpty()) {
            Pair<Integer, Integer> node = q.poll();
            int r = node.getKey(), c = node.getValue();
            visited[r][c] = 1;
            int[] dy = {1, -1, 0, 0};
            int[] dx = {0, 0, 1, -1};
            for(int i = 0; i < 4; i++) {
                int nr = r + dy[i], nc = c + dx[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                    q.add(new Pair(nr, nc));
                    visited[nr][nc] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) 
                    lands++;
            }
        }
        return lands;
    }
}
//Time: O(n * m * 4) => O(n * m), Space: O(n * m)