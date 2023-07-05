// There are 2 versions of this problem:
// Version 1: It is always guaranteed that the array will have an equal number of positive and negative numbers.
// Version 2: Above is not guaranteed.

// Leetcode (Version 1) - My approach:
// —-----------------------------------------------
public int[] rearrangeArray(int[] nums) {
        int i=0, j=0, k=0;
        int res[] = new int[nums.length];
        while(i<nums.length || j<nums.length) {
            while(i<nums.length && nums[i] < 0) {
                i++;
            }
            if(i<nums.length) res[k++] = nums[i++];
            while (j<nums.length && nums[j] >= 0){
                j++;
            }
            if(j<nums.length) res[k++] = nums[j++];
        }
        return res;
    }

// Time: O(2N), Space: O(N)

// Leetcode (Version 1) - Striver’s approach:
// —-----------------------------------------------------
public int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 1;
        int res[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                res[neg] = nums[i];
                neg+=2;
            } else {
                res[pos] = nums[i];
                pos+=2;
            }
        }
        return res;
    }

// Time: O(N), Space: O(N)

// GFG (Version 2) - My approach:
// —----------------------------------------
void rearrange(int arr[], int n) {
        int posPointer=0, negPointer=0, mainPointer=0;
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(arr[i] < 0) {
                negList.add(arr[i]);
            } else {
                posList.add(arr[i]);
            }
        }
        while(posPointer<posList.size() && negPointer<negList.size()) {
            arr[mainPointer++] = posList.get(posPointer++);
            arr[mainPointer++] = negList.get(negPointer++);
        }
        while(posPointer<posList.size()) {
            arr[mainPointer++] = posList.get(posPointer++);
        }
        while(negPointer<negList.size()) {
            arr[mainPointer++] = negList.get(negPointer++);
        }
    }

// Time: O(2N) in worst (when there are all positive or negative elements)
//       O(N) +O(max(posList.size(), negList.size()) in best (equal number of positive and negative elements)

// Space: O(N)

// GFG (Version 2) - Striver’s approach:
// —-----------------------------------------------
void rearrange(int arr[], int n) {
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(arr[i] < 0) {
                negList.add(arr[i]);
            } else {
                posList.add(arr[i]);
            }
        }
        if(negList.size() < posList.size()) {
            for(int i=0; i<negList.size(); i++) {
                arr[2 * i] = posList.get(i);
                arr[2 * i + 1] = negList.get(i);
            }
            int start = 2*negList.size();
            for(int i=negList.size(); i<posList.size(); i++) {
                arr[start] = posList.get(i);
                start++;
            }
        } else {
            for(int i=0; i<posList.size(); i++) {
                arr[2 * i] = posList.get(i);
                arr[2 * i + 1] = negList.get(i);
            }
            int start = 2*posList.size();
            for(int i=posList.size(); i<negList.size(); i++) {
                arr[start] = negList.get(i);
                start++;
            }
        }
    }

// Time: O(2N) in worst
//       O(N) +O(max(pos.size(), neg.size()) in best

// Space: O(N)

//Version 1's solution modified for version 2
class Solution {
    void rearrange(int arr[], int n) {
        int i=0, j=0, k=0;
        int res[] = new int[arr.length];
        while(i<arr.length || j<arr.length) {
            while(i<arr.length && arr[i] < 0) {
                i++;
            }
            if(i<arr.length) res[k++] = arr[i++];
            while (j<arr.length && arr[j] >= 0){
                j++;
            }
            if(j<arr.length) res[k++] = arr[j++];
        }
        System.arraycopy(res, 0, arr, 0, n);
    }
}
//Time: O(3N), Space: O(N)

