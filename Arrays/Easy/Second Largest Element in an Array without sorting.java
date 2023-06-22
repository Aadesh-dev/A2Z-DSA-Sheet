class Solution {
    int print2largest(int arr[], int n) {
        int max=arr[0],secondMax=arr[0],diff=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }
        secondMax=max;
        for(int i=0;i<n;i++) {
            if(arr[i]!=max && max-arr[i]<diff) {
                diff=max-arr[i];
                secondMax=arr[i];
            }
        }
        if(secondMax==max) {
            return -1;
        } else {
            return secondMax;
        }
    }
}

//Time:O(n). It's actually O(2n), Space:O(1)

// Better:
// ---------
class Solution {
    int print2largest(int arr[], int n) {
        int max=Integer.MIN_VALUE,secondMax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(arr[i]>max) {
                secondMax=max;
                max=arr[i];
            }
            if(arr[i]>secondMax && arr[i]!=max) {
                secondMax=arr[i];
            }
        }
        if(secondMax==Integer.MIN_VALUE) {
            return -1;
        } else {
            return secondMax;
        }
    }
}

//Time:O(n), Space:O(1)