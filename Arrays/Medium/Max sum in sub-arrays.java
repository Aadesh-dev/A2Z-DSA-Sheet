//TLE
class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        long min, secondMin, sum = 0;
        for(int i=0; i<N-1; i++) {
            min = Long.MAX_VALUE;
            secondMin = Long.MAX_VALUE;
            for(int j=i; j<N; j++) {
                if(arr[j] <= min) {
                    secondMin = min;
                    min = arr[j];
                }
                if(arr[j] != min && arr[j] < secondMin) {
                    secondMin = arr[j];
                }
                sum = Math.max(sum, min + secondMin);
            }
        }
        return sum;
    }
}
//Time: O(N^2), Space: O(1)

class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        long sum = 0;
        for(int i=0; i<N - 1; i++) {
            sum = Math.max(sum, arr[i] + arr[i + 1]);
        }
        return sum;
    }
}
//Time: O(N), Space: O(1)