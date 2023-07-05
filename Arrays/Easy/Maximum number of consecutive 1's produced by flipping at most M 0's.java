int findZeroes(int arr[], int n, int m) {
        int i = 0, j = 0, zero = 0, len = 0;
        while(j < n) {
            if(arr[j] == 0 ) {
                zero++;
            }
            while(zero > m) {
                if(arr[i] == 0) {
                    zero--;
                }
                i++;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }

        return len;
    }
    
// Time:O(n), Space:O(1)
// This is a sliding window problem. The main idea is to always keep at most m 0s in the window at any point. If there are more than m 0s at a point shrink the window from the left until there are m 0s in the window.