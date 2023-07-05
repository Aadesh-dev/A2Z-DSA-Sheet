//Brute (TLE):

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean duplicate;
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    duplicate = false;
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        for(List<Integer> prevList : list) {
                            int count = 0;
                            for(int x : prevList) {
                                if(x == nums[i] || x == nums[j] || x == nums[k]) {
                                    count++;
                                }
                            }
                            if(nums[i] == prevList.get(0) || nums[i] == prevList.get(1) || nums[i] == prevList.get(2)) {
                                count++;
                            }
                            if(nums[j] == prevList.get(0) || nums[j] == prevList.get(1) || nums[j] == prevList.get(2)) {
                                count++;
                            }
                            if(nums[k] == prevList.get(0) || nums[k] == prevList.get(1) || nums[k] == prevList.get(2)) {
                                count++;
                            }
                            if(count == 6) {
                                duplicate = true;
                                break;
                            }
                        }
                        if(!duplicate) {
                            List<Integer> tempList = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                            list.add(tempList);
                        }
                    }
                }
            }
        }
        return list;
    }

// Time: O(n^3 * m * 3), where n=nums.length, m=list.length, 3=prevList.length
// Space: O(1)

// Optimal:

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int low, high;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            low = i+1;
            high = nums.length - 1;
            while(low < high) {
                if(nums[low] + nums[high] == -nums[i]) {
                    List<Integer> tempList = new ArrayList<>(Arrays.asList(nums[i], nums[low], nums[high]));
                    list.add(tempList);
                    low++;
                    while(low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    high--;
                    while(low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if(nums[low] + nums[high] < -nums[i]) {
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
        return list;
    }

//Time: O(n^2 + n logn) => O(n^2), Auxiliary Space: O(1)
