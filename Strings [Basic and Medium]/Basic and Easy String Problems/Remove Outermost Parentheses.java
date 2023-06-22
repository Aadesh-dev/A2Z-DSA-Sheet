class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder b=new StringBuilder();
        int bracketCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                bracketCount++;
                if(bracketCount != 1) b.append(s.charAt(i));
            } else {
                bracketCount--;
                if(bracketCount != 0) b.append(s.charAt(i));
            }
        }
        return b.toString();
    }
}

//Time: O(n), Space: O(n)
