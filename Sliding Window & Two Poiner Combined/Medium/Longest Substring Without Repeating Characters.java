class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int len = 0;
            for(int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                    len++;
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
}
//Time: O(n * 256), Space: O(256) => O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while(j < s.length()) {
            if(set.contains(s.charAt(j))) {
                while(set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
            } else {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            set.add(s.charAt(j));
            j++;
        }
        return maxLen;
    }
}
//Time: O(2n), Space: O(256) => O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(j < s.length()) {
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j)) >= i) {
                i = map.get(s.charAt(j)) + 1;
            } else {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            map.put(s.charAt(j), j);
            j++;
        }
        return maxLen;
    }
}
//Time: O(n), Space: O(256) => O(1)