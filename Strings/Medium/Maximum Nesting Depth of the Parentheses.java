class Solution {
    public int maxDepth(String s) {
        int bracketCount = 0, depth = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                bracketCount++;
            } else if(s.charAt(i) == ')') {
                bracketCount--;
            }
            depth = Math.max(depth, bracketCount);
        }
        return depth;
    }
}

//Time: O(n), Space: O(1)