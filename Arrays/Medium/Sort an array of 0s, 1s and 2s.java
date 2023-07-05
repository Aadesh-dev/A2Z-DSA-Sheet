public static void sort012(int a[], int n)
    {
        int left=0, right, temp;
        for(int i=0; i<3; i++) {
            while (left < n && a[left] == i ) {
                left++;
            }
            right = left + 1;
            while(right < n) {
                if(a[right] == i) {
                    temp=a[left];
                    a[left]=a[right];
                    a[right]=temp;
                    left++;
                }
                right++;
            }
        }
    }
// Time: O(3*n), Space:O(1)

// Optimal (Dutch national flag algo):
// ------------------------------------------------
public static void sort012(int a[], int n)
    {
        int low=0, mid=0, high=n - 1, temp;
        while(mid <= high) {
            if(a[mid] == 0) {
                temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            } else if(a[mid] == 2) {
                temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            } else {
                mid++;
            }
        }
    }
// Time: O(n), Space: O(1)

// Explanation of DNF logic: 

// There are 3 conditions that the array needs to follow at any time. Our job is to make sure that these conditions are followed:
// 0 to low - 1 => All 0s
// Low to mid - 1 => All 1s
// Mid to high => Unsorted
// High + 1 to n - 1 => All 2s
// Based on the above conditions, the if conditions in the code are written.
// We write the code from the perspective of mid pointer.
// If a[mid] == 0, swap a[mid] with a[low] and low++ and mid++
// If a[mid] == 1, only mid++
// If a[mid] == 2, swap a[mid] with a[high] and high--;

//https://www.youtube.com/watch?v=tp8JIuCXBaU&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=22&ab_channel=takeUforward


