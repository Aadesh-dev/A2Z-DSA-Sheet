class Solution {
    public String longestCommonPrefix(String[] strs) {
        int stringIndex = 0; 
        while(true) {
            char c;
            if(stringIndex != strs[0].length()) {
                c = strs[0].charAt(stringIndex);
            } else {
                return strs[0].substring(0, stringIndex);
            }
            for(int i=1; i<strs.length; i++) {
                if(stringIndex == strs[i].length() || c != strs[i].charAt(stringIndex)) {
                    if(stringIndex == 0) {
                        return "";
                    }
                    return strs[i].substring(0, stringIndex);
                }
            }
            stringIndex++;
        }
    }
}

//Time: O(n * min(length of string in strs[])), Space: O(1)