class Solution {
    public String reverseWords(String s) {
        if(s.length() == 1) return s;
        int endCharIndex = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length() - 1; i>=0; i--) {
            if(s.charAt(i) != ' ') {
                if(i == s.length() - 1 || s.charAt(i + 1) == ' ' || i == 0) {
                    if(i == 0) {
                        if(s.charAt(i + 1) != ' ') {
                            sb.append(s.substring(i, endCharIndex + 1) + " ");
                        } else {
                            sb.append(s.substring(i, i + 1) + " ");
                        }
                    } else {
                        endCharIndex = i;
                    }
                }
            } else {
                if(i != s.length() - 1 && s.charAt(i + 1) != ' ') {
                    sb.append(s.substring(i + 1, endCharIndex + 1) + " ");
                } 
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

//Time: O(n), Space: O(n)
