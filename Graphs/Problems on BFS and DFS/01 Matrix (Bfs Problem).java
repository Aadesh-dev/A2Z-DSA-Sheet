class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] distance = new int[m][n];
        int[][] visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0});
                    visited[i][j] = 1;
                }
            }
        }
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1], d = node[2];
            distance[r][c] = d;
            for(int i = 0; i < 4; i++) {
                int nr = r + dy[i], nc = c + dx[i];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] == 0) {
                    q.add(new int[]{nr, nc, d + 1});
                    visited[nr][nc] = 1;
                }
            }
        }
        return distance;
    }
}
//Time: O(m * n * 4) => O(m * n), Space: O(m * n)