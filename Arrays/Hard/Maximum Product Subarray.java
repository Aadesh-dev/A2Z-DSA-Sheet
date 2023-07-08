// Brute: Run 2 loops and multiply a[i] and a[j]. Store max product at every i and j.

// Time: O(n^2), Space: O(1)

//Optimal:

class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, prefixProduct = 1, suffixProduct = 1;
        for(int i=0; i<nums.length; i++) {
            if(prefixProduct == 0) prefixProduct = 1;
            if(suffixProduct == 0) suffixProduct = 1;

            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - i - 1];

            res = Math.max(res, Math.max(prefixProduct, suffixProduct));
        }
        return res;
    }
}
//There can be 3 scenarios (assuming no 0s):
//1. All positive numbers. Whole array is product.
//2. Even number of negative numbers. Whole array is product.
//3. Odd number of negative numbers. We have to exclude 1 negative number.
//Always exclude either the leftmost or the rightmost negative number.
//This will result in either the prefix(all numbers before the last negative number) or the suffix(all numbers after the first negative number)
//being the max product subarray.
//Hence keep track of the running prefix product and suffix product.
//If any 0 is encountered start current product from 1 as carrying 0 is guranteed to result in a lower product that before.

//Time: O(n), Space: O(1)

//Optimal (Don't say this in the interview as it's unintuitive):

public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, curMax = 1, curMin = 1, temp;
        for(int i=0; i<nums.length; i++) {
            temp = curMax * nums[i];
            curMax = Math.max(curMax * nums[i], Math.max(nums[i], curMin * nums[i]));
            curMin = Math.min(temp, Math.min(nums[i], curMin * nums[i]));
            res = Math.max(res, curMax);
        }
        return res;
    }

//Time: O(n), Space: O(1)
