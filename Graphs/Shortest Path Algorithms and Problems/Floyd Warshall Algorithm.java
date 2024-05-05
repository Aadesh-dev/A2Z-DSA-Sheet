class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == -1) matrix[i][j] = (int) 1e9;
            }
        }
        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == (int) 1e9) matrix[i][j] = -1;
            }
        }
    }
}
//Time: O(n^3), Space: O(1)
//Go via all vertices from every vertex to every other vertex.

//Codingninjas
public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    int[][] matrix = new int[n + 1][n + 1];
    for(ArrayList<Integer> edge : edges) {
      matrix[edge.get(0)][edge.get(1)] = edge.get(2);
    }
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if(matrix[i][j] == 0 && i != j) matrix[i][j] = (int) 1e9;
      }
    }
    for(int via = 1; via <= n; via++) {
      for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
          if(matrix[i][via] != (int) 1e9 && matrix[via][j] != (int) 1e9)
            matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
        }
      }
    }
    return matrix[src][dest];
  }

}
//Time: O(n^3), Space: O(1)