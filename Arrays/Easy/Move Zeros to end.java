class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        int temp,j=1;
        for(int i=0;i<n-1;i++) {
            if(arr[i]==0) {
                while(j<i) j++;
                while(j<n && arr[j]==0) j++;
                if(j<n) {
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
            
        }
    }
}

// Time:O(n), Space:O(1)

// More intuitive and easy to remember:
// -------------------------------------
void pushZerosToEnd(int[] arr, int n) {
        int temp,i=0;
        for(int j=1;j<n;j++) {
            while(arr[i]!=0 && i<n-1) i++;
            if(arr[j]!=0 && j>i) {
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
    }
    
// Time:O(n), Space:O(1)
// Edge cases missed: j has to be >i before swapping


// Even more intuitive and easier to remember:
// -------------------------------------------
void pushZerosToEnd(int[] arr, int n) {
    int i=0, j=i+1;
    while(i<n-1 && j<n) {
        if(arr[i]==0) {
            if(arr[j]==0) {
                j++;
            } else {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        } else {
            i++;
            j++;
        }
    }
}
// Time:O(n), Space:O(1)

// Leetcode follow up: Minimized the total number of operations done
// -----------------------------------------------------------------
public static void zerosToEnd(int[] arr) {

    //finding first zero occurrence
    int k = 0;
    while (k < arr.length) {
      if (arr[k] == 0) {

        break;
      } else {
        k = k + 1;
      }
    }

    //finding zeros and immediate non-zero elements and swapping them
    int i = k, j = k + 1;

    while (i < arr.length && j < arr.length) {
      if (arr[j] != 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;

      }

      j++;

    }
}

//Time:O(n), Space:O(1)