//BFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length, scolor = image[sr][sc];
        if(scolor == color) return image;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        image[sr][sc] = color;
        int[] drow = {1, -1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        while(!q.isEmpty()) {
            Pair<Integer, Integer> pixel = q.poll();
            int r = pixel.getKey(), c = pixel.getValue();
            for(int i = 0; i < 4; i++) {
                int nrow = r + drow[i], ncol = c + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == scolor) {
                    q.add(new Pair(nrow, ncol));
                    image[nrow][ncol] = color;
                }
            }
        }
        return image;
    }
}
//Time :O(m * n), Space: O(m * n)

//DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length, scolor = image[sr][sc];
        if (scolor == color)
            return image;
        int[][] flooded = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flooded[i][j] = image[i][j];
            }
        }
        dfs(flooded, sr, sc, color, scolor);
        return flooded;
    }

    public void dfs(int[][] flooded, int r, int c, int color, int scolor) {
        flooded[r][c] = color;
        int[] drow = { 1, -1, 0, 0 };
        int[] dcol = { 0, 0, 1, -1 };
        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i], ncol = c + dcol[i];
            if (nrow >= 0 && nrow < flooded.length && ncol >= 0 && ncol < flooded[0].length && flooded[nrow][ncol] == scolor) {
                dfs(flooded, nrow, ncol, color, scolor);
            }
        }
    }
}
//Time :O(m * n), Space: O(m * n)