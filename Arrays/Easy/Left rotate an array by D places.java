class Solution
{
    void leftRotate(long arr[], int k,int n)
    {
        k = k % n;
        
        long[] temp=new long[k];
        for(int i=0;i<k;i++) {
            temp[i]=arr[i];
        }
        for(int i=0;i<n-k;i++) {
            arr[i]=arr[i+k];
        }
        for(int i=0;i<k;i++) {
            arr[n-k+i]=temp[i];
        }
    }
}

// Time:O(n), Space:O(n)

// Optimal:
// --------
class Solution
{
    void leftRotate(long arr[], int k,int n)
    {
        k=k%n;
        // Reverse first k elements
        Reverse(arr, 0, k - 1);
        // Reverse last n-k elements
        Reverse(arr, k , n - 1);
        // Reverse whole array
        Reverse(arr, 0, n - 1);
    }
    
    public static void Reverse(long[] arr, int start, int end) {
        while (start <= end) {
          long temp = arr[start];
          arr[start] = arr[end];
          arr[end] = temp;
          start++;
          end--;
        }
    }
}

//Time:O(n), Space:O(1)