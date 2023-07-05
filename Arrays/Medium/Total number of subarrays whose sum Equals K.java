// Brute:
// -------
public int subarraySum(int[] nums, int k) {
    int sum,count=0;
    for(int i=0;i<nums.length;i++) {
        sum=0;
        for(int j=i;j<nums.length;j++) {
            sum+=nums[j];
            if(sum==k) count++;
        }
    }
    return count;
}

// Time:O(n^2), Space:O(1)

// Optimal:
// --------
public int subarraySum(int[] nums, int k) {
    Map<Integer,Integer> map = new HashMap<>();

    map.put(0, 1);

    int sum = 0, count = 0, N=nums.length;

    for(int i=0; i< N; i++){

        sum += nums[i];    

        if(map.containsKey(sum - k)){

            count+=map.get(sum-k);

        }

        map.put(sum, map.getOrDefault(sum, 0) + 1);

    }

    return count;
}
//Time:O(n), Space:O(n)