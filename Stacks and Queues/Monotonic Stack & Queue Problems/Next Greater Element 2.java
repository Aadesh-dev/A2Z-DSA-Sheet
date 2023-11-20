class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 2 * nums.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && s.peek() <= nums[i % nums.length]) s.pop();
            if(i < nums.length) {
                if(s.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = s.peek();
                } 
            }
            s.push(nums[i % nums.length]);
        }
        return res;
    }
}
//Time: O(n), Space: O(n)