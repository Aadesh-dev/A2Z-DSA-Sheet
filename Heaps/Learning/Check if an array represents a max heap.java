class Solution {
    
    public boolean countSub(long arr[], long n)
    {
        for(int i = 0; i < n - 1; i++) {
            int child1 = i * 2 + 1;
            int child2 = i * 2 + 2;
            if((child1 < n && arr[child1] > arr[i]) || (child2 < n && arr[child2] > arr[i])) {
                return false;
            }
        }
        return true;
    }
}
//Time: O(n), Space: O(1)