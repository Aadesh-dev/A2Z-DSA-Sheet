class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Map<Integer, Integer> numCount = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((p1, p2) -> p1.getValue() - p2.getValue());
        int res[] = new int[k];
        for(int i = 0; i < nums.length; i++) {
            numCount.put(nums[i], numCount.getOrDefault(nums[i], 0) + 1);
        }
        for(var entry : numCount.entrySet()) {
            Pair<Integer, Integer> pair = new Pair(entry.getKey(), entry.getValue());
            if(heap.size() < k) {
                heap.add(pair);
            } else if(heap.peek().getValue() < pair.getValue()) {
                heap.poll();
                heap.add(pair);
            }
        }
        int i = 0;
        while(!heap.isEmpty()) {
            res[i] = heap.poll().getKey();
            i++;
        }
        return res;
    }
}
//Time: O(n log(k)), Space: O(n + k)

//LC editorial heap solution
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }
        
        // 1. Build hash map: character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. Keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();    
        }

        // 3. Build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }
}
//Time: O(n log(k)), Space: O(n + k)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> buckets[] = new ArrayList[nums.length + 1];
        Map<Integer, Integer> numCount = new HashMap<>();
        int res[] = new int[k];
        for(int i = 0; i < nums.length; i++) {
            numCount.put(nums[i], numCount.getOrDefault(nums[i], 0) + 1);
        }
        for(int num : numCount.keySet()) {
            if(buckets[numCount.get(num)] == null) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                buckets[numCount.get(num)] = list;
            } else {
                buckets[numCount.get(num)].add(num);
            }
        }
        int index = 0;
        for(int i = buckets.length - 1; i >= 1; i--) {
            if(buckets[i] != null) {
                List<Integer> sameCountNums = buckets[i];
                for(int j = sameCountNums.size() - 1; j >= 0; j--) {
                    if(index < k) {
                        res[index] = sameCountNums.get(j);
                        index++;
                    } else break;
                }
            }
            if(index == k) break;
        }
        return res;
    }
}
//Time: O(n), Space: O(n)
//https://www.youtube.com/watch?v=YPTqKIgVk-k&ab_channel=NeetCode