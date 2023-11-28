class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 1;
        for(int i = 0; i < s.length() - 1; i++) {
            int len = 1, count = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(s.charAt(j) != s.charAt(i)) {
                    if(count < k) {
                        count++;
                    } else {
                        break;
                    }
                } 
                len++;
            }
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(j) != s.charAt(i)) {
                    if(count < k) {
                        count++;
                    } else {
                        break;
                    }
                } 
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
//Time: O(n^2), Space: O(1)

class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 1, i = 0, j = 0;
        int char_count[] = new int[26];
        while(j < s.length()) {
            int maxCount = 1, len = j - i + 1;
            char_count[s.charAt(j) - 'A']++;
            for(int count : char_count) {
                maxCount = Math.max(maxCount, count);
            }
            while(len - maxCount > k) {
               char_count[s.charAt(i) - 'A']--;
               i++;
               len--;
            }
            maxLen = Math.max(maxLen, len);
            j++;
        }
        return maxLen;
    }
}
//Time: O(n * 26) => O(n), Space: O(26) => O(1)