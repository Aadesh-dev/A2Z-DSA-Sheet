class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for(int i = goal - 1; i >= 0; i--) {
            if(i + nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }
}
//Time: O(n), Space: O(1)
//https://www.youtube.com/watch?v=Yan0cv2cLy8&ab_channel=NeetCode