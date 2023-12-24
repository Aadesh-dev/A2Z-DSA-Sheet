public class Solution {
    public static int[] MinToMaxHeap(int n, int[] arr){
        int N = n;
        for(int i = (N - 2) / 2; i >= 0; i--) {
            int pos = i;
            while(pos < N - 1) {
                int child1 = pos * 2 + 1;
                int child2 = pos * 2 + 2;
                int greaterChild = 0;
                if(child1 <= N - 1 && child2 <= N - 1) {
                    greaterChild = arr[child1] >= arr[child2] ? child1 : child2;
                } else if(child1 <= N - 1) {
                    greaterChild = child1;
                } else if(child2 <= N - 1) {
                    greaterChild = child2;
                } else break;
                
                if(arr[pos] < arr[greaterChild]) {
                    int temp = arr[pos];
                    arr[pos] = arr[greaterChild];
                    arr[greaterChild] = temp;
                    pos = greaterChild;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
//Time: O(n logn), Space: O(1)
//https://www.geeksforgeeks.org/convert-min-heap-to-max-heap/