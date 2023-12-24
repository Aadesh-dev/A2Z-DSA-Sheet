class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++) {
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++) {
            if(pq.peek()<nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}
//Time: O(n logk), Space: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
       return quickSelect(nums, 0, nums.length - 1, k);
    }

    static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);
        if(pivot < nums.length - k) {
            return quickSelect(nums, pivot + 1, high, k);
        } else if(pivot > nums.length - k) {
            return quickSelect(nums, low, pivot - 1, k);
        } else {
            return nums[pivot];
        }
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot=low,i=low,j=high;
        while(i<j) {
            while(i<=high && arr[i]<=arr[pivot]) 
            {
                i++;
            }
            while(arr[j]>arr[pivot]) 
            {
                j--;
            }
            if(i<j) {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[pivot];
        arr[pivot]=arr[j];
        arr[j]=temp;
        return j;
    }
}
//Time: Average - O(n), Worst - O(n^2), Space: O(1)
//https://www.youtube.com/watch?v=XEmy13g1Qxc&ab_channel=NeetCode
//TODO: Understand TC better