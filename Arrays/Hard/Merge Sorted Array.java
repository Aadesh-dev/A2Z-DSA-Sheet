public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=m-1, right=n-1, main=nums1.length - 1;
        while(left>=0 && right>=0) {
            if(nums2[right] > nums1[left]) {
                nums1[main] = nums2[right];
                right--;
            } else if(nums2[right] < nums1[left]) {
                nums1[main] = nums1[left];
                left--;
            } else {
                nums1[main] = nums1[left];
                main--;
                nums1[main] = nums2[right];
                left--;
                right--;
            }
            main--;
        }
        while(right >= 0) {
            nums1[main--] = nums2[right--];
        }
}

// Time: O(m+n), Space: O(1)

// GFG:

// TLE:

public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i = 0;
        long temp, temp2;
        while(i<n) {
            if(arr1[i] > arr2[0]) {
                temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                for(int j=0; j<m-1; j++) {
                    if(arr2[j] > arr2[j+1]) {
                        temp2 = arr2[j];
                        arr2[j] = arr2[j+1];
                        arr2[j+1] = temp;
                    }
                }
            }
            i++;
        }
    }
//Iterate through arr1 and compare each element with the first element of arr2. 
//If element from arr1 > element from arr2, swap and sort arr2.

// Time: O(n * m), Space: O(1)

// Optimal - Gap method:

public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i, gap = (int) Math.ceil((n + m) / 2.0);
        long temp;
        while(true) {
            i = 0;
            for(int j=gap; j<n+m; j++) {
                if(i<n && j<n) {
                    if(arr1[i] > arr1[j]) {
                        temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    } 
                } else if(i < n && j >= n) {
                    if(arr1[i] > arr2[j - n]) {
                        temp = arr1[i];
                        arr1[i] = arr2[j - n];
                        arr2[j - n] = temp;
                    }
                } else {
                   if(arr2[i - n] > arr2[j - n]) {
                        temp = arr2[i - n];
                        arr2[i - n] = arr2[j - n];
                        arr2[j - n] = temp;
                    } 
                }
                i++;
            }
            if(gap == 1) {
                break;
            }
            gap = (int) Math.ceil(gap / 2.0);
        }
    }
//Take the initial gap as ceil of half of both arrays. Treat both arrays as a single combined array. Start i from 0 and compare it with the gap and if found greater, swap. 
//Each iteration will happen until the gap reaches the end of both arrays. After every iteration divide the gap by 2. Keep doing this until the gap reaches 1.

//Time: O(n + m * log(n + m)), Space: O(1)

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i = n - 1, j = 0;
        long temp;
        while(i >= 0 && j < m) {
            if(arr1[i] > arr2[j]) {
                temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            } else {
                break;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}

//Time: O(min(n,m) + n * log(n) + m * log(m)), Space: O(1)



