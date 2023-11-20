//Brute
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        for(int i = 0; i < height.length; i++) {
            int leftMax = height[i], rightMax = height[i];
            for(int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(height[j], leftMax);
            }
            for(int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(height[j], rightMax);
            }
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }
}
//Time: O(n^2), Space: O(1)

//Better
class Solution {
    public int trap(int[] height) {
        int ans = 0, max = 0;
        int prefix[] = new int[height.length];
        int suffix[] = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            prefix[i] = max = Math.max(height[i], max);
        }
        max = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            suffix[i] = max = Math.max(height[i], max);
        }
        for(int i = 0; i < height.length; i++) {
            ans += Math.min(prefix[i], suffix[i]) - height[i];
        }
        return ans;
    }
}
//Time: O(n), Space: O(n)

//Optimal
class Solution {
    public int trap(int[] height) {
        int ans = 0, l = 0, r = height.length - 1, leftMax = 0, rightMax = 0;
        while(l < r) {
            if(height[l] <= height[r]) {
                if(height[l] >= leftMax) {
                    leftMax = height[l];
                } else {
                    ans += leftMax - height[l];
                }
                l++;
            } else {
                if(height[r] >= rightMax) {
                    rightMax = height[r];
                } else {
                    ans += rightMax - height[r];
                }
                r--;
            }
        }
        return ans;
    }
}
//Time: O(n), Space: O(1)