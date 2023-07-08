// Brute: Run 2 loops and at each i and j check condition. Increment count if arr[i] > arr[j].

// Time: O(n^2), Space: O(1)

// Optimal:

static long inversionCount(long arr[], long N)
    {
        long count = 0;
        count = mergeSort(arr, count, 0, (int) N-1);
        return count;
    }
    
    static long mergeSort(long arr[], long count, int low, int high) {
        if(low >= high) {
            return count;
        }
        int mid = low + (high - low)/2;
        long tempCount = mergeSort(arr, count, low, mid);
        tempCount = mergeSort(arr, tempCount, mid+1, high);
        return sort(arr, tempCount, low, mid, high);
    }
    
    static long sort(long arr[], long count, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        long arr1[] = new long[n1];
        long arr2[] = new long[n2];
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
            if(arr1[left] <= arr2[right]) {
                arr[main++] = arr1[left++];
            } else {
                arr[main++] = arr2[right++];
                count += n1 - left;
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

//Time: O(n logn), Space: O(n)
//In the merging stage, if left array's element > right array's element then that is an inversion and incrememnt count, but since this is a sorted array, all elements to right of left array's element will also be greater so incrment by count of elements to it's right including itself.
//Ask the interviewer that you'll be distorting the input array and should you use a copy array.
