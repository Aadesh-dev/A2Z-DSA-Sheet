public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sum=0, low, high;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            low = i+1;
            high = nums.length - 1;
            while(low < high) {
                if(Math.abs((nums[i] + nums[low] + nums[high]) - target) < diff) {
                    diff = Math.abs((nums[i] + nums[low] + nums[high]) - target);
                    sum = nums[i] + nums[low] + nums[high];
                }
                if((nums[i] + nums[low] + nums[high] - target) == 0) {
                    return nums[i] + nums[low] + nums[high];
                } else if((nums[i] + nums[low] + nums[high]) - target < 0) {
                    low++;
                    while(low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                } else {
                    high--;
                    while(low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                }
            }
        }
        return sum;
    }

//Time: O(n^2 + n logn) => O(n^2), Auxiliary Space: O(1)
