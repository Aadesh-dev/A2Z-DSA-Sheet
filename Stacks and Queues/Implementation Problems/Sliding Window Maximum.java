class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j <= i + k - 1; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }
}
//Time: O(n^2), Space: O(1)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offer(i);
            if(i >= k - 1) {
                while(!dq.isEmpty() && dq.peek() < i - (k - 1)) dq.poll();
                list.add(nums[dq.peek()]);
            }
        }
        int[] res = list.stream().mapToInt(i -> i).toArray();
        return res;
    }
}
//Time: O(n), Space: O(n)
//Similar to previous greater element.
//Step 1: Remove all the left smaller elements.
//Step 2: Insert current element at the tail.
//Step 3: Remove all the out of boundary(outside the sliding window) elements from the head.
//Step 4: Add the remaining element from the head into resultant array.


//Used array only instead of list
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offer(i);
            if(i >= k - 1) {
                while(!dq.isEmpty() && dq.peek() < i - (k - 1)) dq.poll();
                res[i - (k - 1)] = nums[dq.peek()];
            }
        }
        return res;
    }
}
//Time: O(n), Space: O(k)