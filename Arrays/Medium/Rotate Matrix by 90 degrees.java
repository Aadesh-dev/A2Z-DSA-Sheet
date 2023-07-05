//Clockwise (Leetcode):
public void rotate(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;
        int temp;
	   //Transpose of matrix
        for(int i=0; i<rows-1; i++) {
            for(int j=i+1; j<cols; j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0; i<rows; i++) {
            reverse(matrix[i]);
        }
    }


    public static void reverse(int[] row) {
        int i=0, j=row.length-1, temp;
        while(i<j) {
            temp=row[i];
            row[i]=row[j];
            row[j]=temp;
            i++;
            j--;
        }
    }
// Time: O(n/2 * n/2) + O(n * n/2) => O(n^2), Space: O(1)

// Anti-clockwise (GFG):

static void rotateby90(int matrix[][], int n) 
    { 
       int rows=matrix.length, cols=matrix[0].length;
        int temp;
        for(int i=0; i<rows-1; i++) {
            for(int j=i+1; j<cols; j++) {
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        reverse(matrix, n);
    }

    public static void reverse(int[][] matrix, int n) {
        int i=0, j=n-1;
        int temp[] = new int[n];
        while(i<j) {
            temp=matrix[i];
            matrix[i]=matrix[j];
            matrix[j]=temp;
            i++;
            j--;
        }
    }

//Time: O(n/2 * n/2) + O(n/2) => O(n^2), Space: O(1)
