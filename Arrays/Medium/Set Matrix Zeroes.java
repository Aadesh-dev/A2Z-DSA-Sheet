public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        Set<Integer> rowZeroes = new HashSet<>();
        Set<Integer> colZeroes = new HashSet<>();
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    rowZeroes.add(i);
                    colZeroes.add(j);
                }
            }
        }
        Iterator<Integer> it = rowZeroes.iterator();
        while(it.hasNext()) {
            int element = it.next();
            for(int j=0; j<cols; j++) {
                matrix[element][j] = 0;
            }
        }
        it = colZeroes.iterator();
        while(it.hasNext()) {
            int element = it.next();
            for(int i=0; i<rows; i++) {
                matrix[i][element] = 0;
            }
        }
    }

// Time: O(3*(m*n)) => O(m*n), Space: O(m+n)

// Optimal:

public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        boolean col = true;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == 0) {
                    if(j == 0) {
                        col = false;
                    } else {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for(int i=rows - 1; i>=0; i--) {
            for(int j=cols - 1; j>=0; j--) {
                if(j == 0 && !col) {
                    matrix[i][j] = 0;
                }
                else if((matrix[0][j] == 0 || matrix[i][0] == 0) && j!=0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

//Time: O(m*n + m*n), Space: O(1)

//Easier

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }
        
    }
}

//Time: O(m*n + m*n), Space: O(1)
