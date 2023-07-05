class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int low, high;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<nums.length-2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                low = j + 1;
                high = nums.length - 1;
                while(low < high) {
                    long sum = (long)nums[low] + (long)nums[high] + (long)nums[i] + (long)nums[j];
                    if(sum == target) {
                    List<Integer> tempList = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                    list.add(tempList);
                    low++;
                    while(low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    high--;
                    while(low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if(sum < target) {
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
        }
        return list;
    }
}

//Time: O(n^3), Space: O(1)
