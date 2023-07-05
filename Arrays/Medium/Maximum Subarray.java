// Kadane’s algo:
// —----------------
public int maxSubArray(int[] nums) {
        int sum=0, maxSum=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            maxSum=Math.max(sum, maxSum);
            if(sum < 0) {
                sum=0;
            }
        }
        return maxSum;
    }

// Time: O(n), Space: O(1)

// Possible follow-up: Also print the sub-array along with sum. Could be any sub-array as there can be more than 1 sub-arrays.
public int maxSubArray(int[] nums) {
        int sum=0, maxSum=Integer.MIN_VALUE, finalStart = -1,
        finalEnd = -1, start;
        for(int i=0; i<nums.length; i++) {
            if(sum == 0) start = i;
            sum+=nums[i];
            if(sum > maxSum) {
                maxSum = sum;
                finalStart = start;
                finalEnd = i;
            }
            if(sum < 0) {
                sum=0;
            }
        }
        return maxSum;
    }

