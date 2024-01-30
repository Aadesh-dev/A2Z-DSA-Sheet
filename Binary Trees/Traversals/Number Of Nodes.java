public class Solution {
    public static int numberOfNodes(int N){
        return (int)(Math.pow(2, N) - Math.pow(2, N - 1));
    }
}
//Time: O(1), Space: O(1)