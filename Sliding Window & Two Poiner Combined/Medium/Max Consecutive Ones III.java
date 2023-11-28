class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            int len = 0, count = 0;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] == 0) {
                    if(count < k) {
                        count++;
                    } else {
                        break;
                    }
                } 
                len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
//Time: O(n^2), Space: O(1)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, i = 0, j = 0, count = 0;
        while(j < nums.length) {
             if(nums[j] == 0) count++;
             while(count > k) {
                 if(nums[i] == 0) count--;
                 i++;
             }
             maxLen = Math.max(maxLen, j - i + 1);
             j++;     
        }
        return maxLen;
    }
}
//Time: O(n), Space: O(1)