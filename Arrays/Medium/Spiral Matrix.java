public List<Integer> spiralOrder(int[][] matrix) {
        int rows=matrix.length, cols=matrix[0].length;
        int top=0, bottom=rows-1;
        int left=0, right=cols-1;
        List<Integer> list = new ArrayList<>();
        while(top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom) {
                for(int i=right; i>=left; i--) {
                    list.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if(left<=right) {
                for(int i=bottom; i>=top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            left++;
        }
        return list;
    }

// Time: O(rows * cols), Space: O(1)

// GFG version:

public int findK(int a[][], int n, int m, int k)
	{
	    int rows=a.length, cols=a[0].length, count=0;
        int top=0, bottom=rows-1;
        int left=0, right=cols-1;
        while(top<=bottom && left<=right) {
            for(int i=left; i<=right; i++) {
                count++;
                if(count==k) return a[top][i];
            }
            top++;
            for(int i=top; i<=bottom; i++) {
                count++;
                if(count==k) return a[i][right];
            }
            right--;
            if(top<=bottom) {
                for(int i=right; i>=left; i--) {
                    count++;
                    if(count==k) return a[bottom][i];
                }
            }
            bottom--;
            if(left<=right) {
                for(int i=bottom; i>=top; i--) {
                    count++;
                    if(count==k) return a[i][left];
                }
            }
            left++;
        }
        return 0;
	}

//Time: O(rows * cols), Space: O(1)
