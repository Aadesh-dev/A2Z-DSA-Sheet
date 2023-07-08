public int reversePairs(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length - 1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] > 2 * (long) nums[j]) count++;
            }
        }
        return count;
    }

//Time: O(n^2), Space: O(1)


public int reversePairs(int[] nums) {
        int count = 0;
        count = mergeSort(nums, count, 0, nums.length-1);
        return count;
    }


    static int mergeSort(int arr[], int count, int low, int high) {
        if(low >= high) {
            return count;
        }
        int mid = low + (high - low)/2;
        int tempCount = mergeSort(arr, count, low, mid);
        tempCount = mergeSort(arr, tempCount, mid+1, high);
        return sort(arr, tempCount, low, mid, high);
    }
   
    static int sort(int arr[], int count, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];
        int left = 0;
        int right = 0;
       
        for(int i=low; i<=mid; i++) {
            arr1[left++] = arr[i];
        }
       
        for(int i=mid+1; i<=high; i++) {
            arr2[right++] = arr[i];
        }
        left = 0;
        right = 0;
        int main = low;


        while(left < n1 && right < n2) {
            if(arr1[left] > 2 * (long) arr2[right]) {
                count += n1 - left;
                right++;
            } else {
                left++;
            }
        }
        left = 0;
        right = 0;
       
        while(left < n1 && right < n2) {
            if(arr1[left] <= arr2[right]) {
                arr[main++] = arr1[left++];
            } else {
                arr[main++] = arr2[right++];
            }
        }
       
        while(left < n1) {
            arr[main++] = arr1[left++];
        }
       
        while(right < n2) {
            arr[main++] = arr2[right++];
        }
       
        return count;
    }

//Time: O(2n *  logn), Space: O(n)
//We need a separate loop here compared to only 1 loop in Count Inversions because checking left > 2 * right will not result in a proper array. We will be missing some elements from the left.
//If we actually used the normal merge loop to check the condition: 
// [2,4,3,5,1]

// [2 3 4] [1 5]

// [1 3 4 5] missing 2 as we skip more elements on the left.
//Ask the interviewer that you'll be distorting the input array and should you use a copy array.

