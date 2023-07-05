//Brute - Power set (TLE):

static int subsetXOR(int arr[], int N, int K) {
        int xor, count=0;
        for(int i=0; i < Math.pow(2,N); i++) {
            xor = 0;
            for(int j=0; j<N; j++) {
                if((i & (1 << j)) != 0) {
                    xor = xor ^ arr[j];
                }
            }
            if(xor == K) count++;
        }
        return count;
    }

// Time: O(2^N * N), Space: O(1)

// There are 2^(N-1) possible subsets. We check if the jth bit is set in a number from the range 0 to 2^(N-1) and if it’s set pick the jth element from the array as part of the current subset. By doing this with all numbers in the range 0 to 2^(N-1) we generate all subsets.
// 1<<j is 1 shifted by j positions, eg. 1<<4 is 1000. If i is 6 then we are checking if the 4th bit is set in 6: 0110 & 1000 which gives 0. If the result is 0 then the bit is not set and if the result is 1 then the bit is set.

// Power Set | Print all Subsequences: https://www.youtube.com/watch?v=b7AYbpM5YrE&ab_channel=takeUforward

// Recursive:

static int subsetXOR(int arr[], int N, int K) {
        int xor=0, count=0;
        return recSubsetXOR(0, arr, K, xor, count);
    }
    
    static int recSubsetXOR(int idx, int arr[], int K, int xor, int count) {
        if(idx >= arr.length) {
            if(xor == K) {
                count++;
            }
            return count;
        }
        xor ^= arr[idx];
        int count1 = recSubsetXOR(idx + 1, arr, K, xor, count);
        xor ^= arr[idx];
        int count2 = recSubsetXOR(idx + 1, arr, K, xor, count1);
        return count2;
    }

// Time: O(2^N), Space: O(N)

// For every element of the array, we can either take it or not take it in a subset. The first recursive call is when we take it and second is for when we don’t take it. The base case is when a subset is generated and we check if the XOR of this subset equal to K.

// L6. Recursion on Subsequences | Printing Subsequences: https://www.youtube.com/watch?v=AxNNVECce8c&t=156s&ab_channel=takeUforward

// Optimal solution pending
