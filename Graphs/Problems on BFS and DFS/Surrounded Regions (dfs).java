class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O' && visited[i][j] == 0) {
                    dfs(board, visited, i, j, n, m);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && visited[i][j] == 0) 
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int[][] visited, int r, int c, int n, int m) {
        visited[r][c] = 1;
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for(int i = 0; i < 4; i++) {
            int nr = r + dy[i], nc = c + dx[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O' && visited[nr][nc] == 0) {
                dfs(board, visited, nr, nc, n, m);
            }
        }
    }
}
//Time: O(n * m * 4) => O(n * m), Space: O(n * m)