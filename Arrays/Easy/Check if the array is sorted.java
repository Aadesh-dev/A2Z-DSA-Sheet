class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        int[] sorted=new int[n];
        for(int i=0;i<n;i++) {
            sorted[i]=arr[i];
        }
        Arrays.sort(sorted);
        return Arrays.equals(arr,sorted);
    }
}

// Time:O(nlogn), Space:O(1)

// Optimal:
// ---------
class Solution {
    boolean arraySortedOrNot(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
          if (arr[i] < arr[i - 1])
            return false;
        }

        return true;
    }
}

//Time:O(n), Space:O(1)