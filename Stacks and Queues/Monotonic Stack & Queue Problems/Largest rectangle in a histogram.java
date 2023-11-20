//Brute (TLE)
class Solution {
    public int largestRectangleArea(int[] heights) {
       int area = Integer.MIN_VALUE;
       for(int i = 0; i < heights.length; i++) {
           area = Math.max(area, heights[i]);
           int minHeight = heights[i];
           for(int j = i + 1; j < heights.length; j++) {
               minHeight = Math.min(minHeight, heights[j]);
               area = Math.max(area, minHeight * (j + 1 - i));
           }
       }
       return area;
    }
}
//Time: O(n^2), Space: O(1)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int area = Integer.MIN_VALUE;
       int leftSmaller[] = new int[heights.length];
       int rightSmaller[] = new int[heights.length];
       Stack<Integer> s = new Stack<>();
       for(int i = 0; i < heights.length; i++) {
           while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
           leftSmaller[i] = s.isEmpty() ? 0 : s.peek() + 1;
           s.push(i);
       }
       s = new Stack<>();
       for(int i = heights.length - 1; i >= 0 ; i--) {
           while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
           rightSmaller[i] = s.isEmpty() ? heights.length - 1 : s.peek() - 1;
           area = Math.max(area, (rightSmaller[i] - leftSmaller[i] + 1) * heights[i]);
           s.push(i);
       }
       return area;
    }
}
//Time: O(n), Space: O(n)