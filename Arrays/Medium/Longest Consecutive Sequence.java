public int longestConsecutive(int[] nums) {
        if(nums.length == 1) return 1;
      int count = 0, max = -1;
      //Set<Integer> set = new TreeSet<Integer>();
      Arrays.sort(nums);
      for(int i=0; i<nums.length-1; i++) {
          if(Math.abs(nums[i] - nums[i+1]) == 1){
              count++;
          } else if(Math.abs(nums[i] - nums[i+1]) != 0) {
              count = 0;
          }
          max = Math.max(count, max);
      }
      return max + 1;
    }

// Time: O(n logn) + O(n), Space: O(1)

// Optimal:

public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count, max = 0;
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int temp = it.next();
            if(!set.contains(temp - 1)) {
                count = 1;
                while(set.contains(temp + 1)) {
                    count++;
                    temp++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

// Time: O(n)(to add elements in set) + O(n)(iterate over set) + O(n)(to increment count for all greater consecutive elements) => O(3 * n) => O(n)

// Space: O(n)
