public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0, max = 0;

        for(int i=0; i< N; i++){

            sum += A[i];

            if(map.containsKey(sum - K)){

                max = Math.max(max, i-map.get(sum-K));

            }

            if(!map.containsKey(sum)) map.put(sum, i);

        }

        return max;
    }
    
// Time:O(n), Space:O(n)
// Here sliding window approach won't work as we have negative numbers in input.

// Sample working:
// 17 15
// -13 0 6 15 16 2 15 -12 17 -16 0 -3 19 -3 2 -9 -6

// [{-13,0},{-7,2},{8,3},{24,4},{26,5},{41,6},{29,7},{46,8},{30,9},{27,11},{46,12},{43,13},{45,14},{36,15},{30,16}]
// max=5

//Alternate
class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0, max = 0;

        for(int i=0; i< N; i++){

            sum += A[i];
            
            if(sum == K) {
                
                max = Math.max(max, i + 1);
                
            } else if(map.containsKey(sum - K)){

                max = Math.max(max, i-map.get(sum-K));

            }

            if(!map.containsKey(sum)) map.put(sum, i);

        }

        return max;
    }
    
}
// Time:O(n), Space:O(n)


// Sliding window approach:
public static int longestSubarrayWithSumK(int []a, long k) {
    int i=0,j=0,len=0;
    long sum=0;
    while(j<a.length) {
        sum+=a[j];
        while(sum>k) {
            sum-=a[i];
            i++;
        }
        if(sum==k) {
            len=Math.max(len,j-i+1);
        }
        j++;
    }
    return len;
}
// Time:O(n), Space:O(1)
// Sliding window approach will only work when there are no negatives in the array.
// https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_6682399?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTab=1