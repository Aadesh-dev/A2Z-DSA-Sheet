// Striver’s approach but my code:
public void nextPermutation(int[] nums) {
        int firstSmall = -1, greaterThanFirstSmall = 0;
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                firstSmall = i - 1;
                break;
            }
        }
        if(firstSmall != -1) {
            for(int i=nums.length-1; i>firstSmall; i--) {
                if(nums[i] > nums[firstSmall]) {
                    greaterThanFirstSmall = i;
                    break;
                }
            }
            swap(nums, firstSmall, greaterThanFirstSmall);
        }
        reverse(nums, firstSmall + 1, nums.length-1);
    }
   
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
   
    static void reverse(int arr[], int start, int end) {
        while(start < end) swap(arr, start++ , end--);
    }

//Time: O(n), Space: O(1)

//https://www.youtube.com/watch?v=JDOXKqF60RQ&ab_channel=takeUforward
