class Solution {
    public int leastInterval(char[] tasks, int n) {
        int least_time = 0;
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        for(int count : map.values()) {
            max_heap.add(count);
        }
        while(true) {
            least_time++;
            if(!max_heap.isEmpty()) {
                int max_count_element = max_heap.poll();
                if(max_count_element > 1) {
                    Pair<Integer, Integer> pair = new Pair<>(max_count_element - 1, least_time + n);
                    queue.add(pair);
                }
            }
            if(!queue.isEmpty() && queue.peek().getValue() == least_time) {
                max_heap.add(queue.poll().getKey());
            }
            if(max_heap.isEmpty() && queue.isEmpty()) return least_time;
        }
    }
}
//Time: O(n), Space: O(n)