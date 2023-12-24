class KthLargest {

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if(heap.size() < k) {
            heap.add(val);
        }else if(heap.peek() < val) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
//Time: O(log(k)), Space: O(k)

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

//GFG
class Solution {
    
    static int[] kthLargest(int k, int[] arr, int n) {
        int res[] = new int[n];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < k - 1; i++) {
            heap.add(arr[i]);
            res[i] = -1;
        }
        heap.add(arr[k - 1]);
        res[k - 1] = heap.peek();
        for(int i = k; i < n; i++) {
            if(arr[i] > heap.peek()) {
                heap.poll();
                heap.add(arr[i]);
            }
            res[i] = heap.peek();
        }
        return res;
    }
};
//Time: O(n log(k)), Space: O(k)